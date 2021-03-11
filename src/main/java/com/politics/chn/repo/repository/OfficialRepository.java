package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.repo.dao.PersonDao;
import com.politics.chn.repo.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 12:20
 */
@Repository
public class OfficialRepository {
    private PersonDao personDao;

    private ProfileDao profileDao;

    @Autowired
    private void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Autowired
    private void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public Boolean addOfficial(OfficialDO officialDO) {
        PersonDO personDO = officialDO.getPerson();
        List<ProfileDO> profileDOS = officialDO.getProfiles();
        return addPerson(personDO) && addProfiles(profileDOS);
    }

    private Boolean addPerson(PersonDO personDO) { return personDao.addOne(personDO); }

    private Boolean addProfiles(List<ProfileDO> profileDOs) { return profileDao.addMany(profileDOs); }

    public Boolean deleteOfficial(long id) {
        return personDao.deleteOne(id) && profileDao.deleteOneByPersonId(id);
    }

    public Boolean updateOfficial(OfficialDO officialDO) {
        PersonDO personDO = officialDO.getPerson();
        List<ProfileDO> profileDOS = officialDO.getProfiles();
        return updatePerson(personDO) && updateProfiles(profileDOS);
    }

    private Boolean updatePerson(PersonDO personDO) {
        return personDao.updateOne(personDO);
    }

    private Boolean updateProfiles(List<ProfileDO> profileDOs) {
        return profileDao.updateMany(profileDOs);
    }

    public List<OfficialDO> getAllOfficial() {
        List<OfficialDO> officialList = new ArrayList<>();
        List<PersonDO> personList = personDao.getAll();
        personList.forEach(person -> {
            officialList.add(new OfficialDO(person));
        });
        return officialList;
    }

    public OfficialDO getOfficialById(Long id) {
        PersonDO person = personDao.getOneById(id);
        List<ProfileDO> profileList = profileDao.getOneByPersonId(id);
        OfficialDO official = new OfficialDO(person, profileList);
        return official;
    }

}
