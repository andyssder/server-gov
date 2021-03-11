package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.repo.dao.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-19 21:35
 */
@Repository
public class ProfileDao {
    private ProfileMapper profileMapper;

    @Autowired
    private void setProfileMapper(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public boolean addOne(ProfileDO profileDO) {
        return profileMapper.insertOne(profileDO) > 0;
    }

    public boolean addMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        int result = profileMapper.insertMany(profileDOs);
        return result == profileDOs.size();
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        String field = "id";
        return realDelete ? profileMapper.realDeleteOne(field, id) > 0 : profileMapper.deleteOne(field, id) > 0;
    }

    public boolean deleteOneByPersonId(long id) {
        return deleteOneByPersonId(id, false);
    }

    public boolean deleteOneByPersonId(long id, boolean realDelete) {
        String field = "person_id";
        return realDelete ? profileMapper.realDeleteOne(field, id) > 0 : profileMapper.deleteOne(field, id) > 0;
    }

    public boolean updateOne(ProfileDO profileDO) {
        return profileMapper.updateOne(profileDO) > 0;
    }

    public boolean updateMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        return profileMapper.updateMany(profileDOs) > 0;
    }

    public List<ProfileDO> getAll() {
        return profileMapper.getAll();
    }

    public List<ProfileDO> getOneByPersonId(Long personId) {
        return profileMapper.getByPersonId(personId);
    }

    public ProfileDO getOneById(Long id) {
        return profileMapper.getOneById(id);
    }

}
