package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.Official;
import com.politics.chn.domain.official.entity.Person;
import com.politics.chn.domain.official.entity.Profile;
import com.politics.chn.domain.official.query.OfficialQuery;
import com.politics.chn.domain.official.repository.OfficialRepository;
import com.politics.chn.repo.official.dao.PersonDao;
import com.politics.chn.repo.official.dao.ProfileDao;
import com.politics.chn.repo.official.po.PersonPO;
import com.politics.chn.repo.official.po.ProfilePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2021-12-05
 */
@Repository
public class OfficialRepositoryImpl implements OfficialRepository {

    private PersonDao personDao;

    private ProfileDao profileDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Override
    public Official find(Long id) {
        PersonPO personPO = personDao.getOneById(id);
        Person person = BeanUtil.toBean(personPO, Person.class);

        List<ProfilePO> profilePOS = profileDao.getByPersonId(id);
        List<Profile> profiles = profilePOS.stream().map(profileDO -> BeanUtil.toBean(profileDO, Profile.class)).collect(Collectors.toList());

        return new Official(person, profiles);
    }

    @Override
    public List<Official> query(OfficialQuery query) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean remove(Long id) {
        return personDao.deleteOne(id) && profileDao.deleteOneByPersonId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean save(Official official) {
        Person person = official.getPerson();
        if (Objects.isNull(person.getId())) {
            return add(official);
        } else {
            return update(official);
        }
    }

    private boolean add(Official official) {
        Person person = official.getPerson();
        PersonPO personPO = BeanUtil.toBean(person, PersonPO.class);
        List<Profile> profiles = official.getProfiles();
        if (!personDao.addOne(personPO)) {
            return false;
        }
        long personId = personPO.getId();
        List<ProfilePO> profilePOS = profiles.stream().map(profileDO -> {
            ProfilePO profilePO = BeanUtil.toBean(profileDO, ProfilePO.class);
            profilePO.setPersonId(personId);
            return profilePO;
        }).collect(Collectors.toList());

        return profileDao.addMany(profilePOS);
    }

    private boolean update(Official official) {

        Person person = official.getPerson();
        Long personId = person.getId();
        List<ProfilePO> profilePOS = official.getProfiles().stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfilePO.class)).collect(Collectors.toList());
        List<Long> remainIds = new ArrayList<>();
        profilePOS.forEach(profile -> {
            profile.setPersonId(personId);
            if (profile.getId() != null) {
                remainIds.add(profile.getId());
            }
        });
        List<ProfilePO> oldProfileList = profileDao.getByPersonId(personId);
        List<Long> oldProfileIds = oldProfileList.stream().map(ProfilePO::getId).collect(Collectors.toList());

        List<Long> deleteIds = CollectionUtil.subtractToList(oldProfileIds, remainIds);
        // TODO: 批量删除
        // profileDao.deleteMany(deleteIds);
        deleteIds.forEach(id -> profileDao.deleteOne(id));
        PersonPO personPO = BeanUtil.toBean(person, PersonPO.class);
        return personDao.updateOne(personPO) && profileDao.updateMany(profilePOS);
    }

    @Override
    public List<Official> queryPerson(OfficialQuery query) {
        List<Official> officialList = new ArrayList<>();
        List<PersonPO> personList = personDao.getAll();
        personList.forEach(person -> officialList.add(new Official(BeanUtil.toBean(person, Person.class))));
        return officialList;
    }
}
