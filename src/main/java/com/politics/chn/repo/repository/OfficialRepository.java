package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.model.po.PersonPO;
import com.politics.chn.repo.dao.PersonDao;
import com.politics.chn.repo.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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
        return true;
    }

    private Boolean addProfiles(List<OfficialDO> officialDO) { return true; }

    public Boolean deleteOfficial(long id) {
        return personDao.deleteOne(id) && profileDao.deleteOneByPersonId(id);
    }

    public Boolean deleteProfile(long id) { return profileDao.deleteOne(id); }

    public Boolean deleteProfiles(List<Long> ids) { return true; }

    public Boolean updateOfficial(long id, OfficialDO officialDO) {
        return true;
    }

    private Boolean updatePerson(long id, PersonDO personDO) {
        return true;
    }

    private Boolean updateProfiles(long id, List<ProfileDO> profileDOs) {
        return true;
    }

    public List<OfficialDO> getAllOfficial() {
        return null;
    }

    public OfficialDO getOfficialById() { return null; }

}
