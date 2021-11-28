package com.politics.chn.service.official;

import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.domain.official.OfficialDO;
import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.domain.official.entity.ProfileDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Repository
public class OfficialService {
    private PersonService personService;

    private ProfileService profileService;

    @Autowired
    private void setPersonService(PersonService personService) {
        this.personService = personService;
    }

    @Autowired
    private void setProfileService(ProfileService profileService) {
        this.profileService = profileService;
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean addOfficial(OfficialDO officialDO) {
        PersonDO person = officialDO.getPerson();
        Date now = new Date();
        person.setCreateTime(now);
        person.setUpdateTime(now);
        List<ProfileDO> profileList = officialDO.getProfiles();
        if (!personService.addPerson(person)) {
            return false;
        }
        long id = person.getId();
        profileList.forEach(profile -> {
            profile.setPersonId(id);
        });
        return profileService.addMany(profileList);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean deleteOfficial(long id) {
        return personService.deletePerson(id) && profileService.deleteOneByPersonId(id);
    }

    @Transactional(rollbackFor = Exception.class)
    public Boolean updateOfficial(OfficialDO officialDO) {
        PersonDO person = officialDO.getPerson();
        Long personId = person.getId();
        person.setUpdateTime(new Date());
        List<ProfileDO> profileList = officialDO.getProfiles();
        List<Long> remainIds = new ArrayList<>();
        profileList.forEach(profile -> {
            profile.setPersonId(personId);
            if (profile.getId() != null) {
                remainIds.add(profile.getId());
            }
        });
        List<ProfileDO> oldProfileList = profileService.getOneByPersonId(personId);
        List<Long> oldProfileIds = new ArrayList<>();
        oldProfileList.forEach(profile -> {
            oldProfileIds.add(profile.getId());
        });
        List<Long> deleteIds = CollectionUtil.subtractToList(oldProfileIds, remainIds);
        // TODO: 批量删除
        // profileDao.deleteMany(deleteIds);
        deleteIds.forEach(id -> {
            profileService.deleteOne(id);
        });
        return personService.updatePerson(person) && profileService.updateMany(profileList);
    }

    public List<OfficialDO> getAllOfficial() {
        List<OfficialDO> officialList = new ArrayList<>();
        List<PersonDO> personList = personService.getAllPerson();
        personList.forEach(person -> {
//            List<ProfileDO> profiles = profileService.getOneByPersonId(person.getId());
            officialList.add(new OfficialDO(person));
        });
        return officialList;
    }

    public OfficialDO getOfficialById(Long id) {
        PersonDO person = personService.getPersonById(id);
        List<ProfileDO> profileList = profileService.getOneByPersonId(id);
        OfficialDO official = new OfficialDO(person, profileList);
        return official;
    }

}
