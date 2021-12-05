package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.ProfileMapper;
import com.politics.chn.repo.official.po.ProfilePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Repository
public class ProfileDao {
    private ProfileMapper profileMapper;

    @Autowired
    private void setProfileMapper(ProfileMapper profileMapper) {
        this.profileMapper = profileMapper;
    }

    public boolean addOne(ProfilePO profilePO) {
        return profileMapper.insertOne(profilePO) > 0;
    }

    public boolean addMany(List<ProfilePO> profilePOS) {
        if (profilePOS == null || profilePOS.isEmpty()) {
            return true;
        }
        int result = profileMapper.insertMany(profilePOS);
        return result == profilePOS.size();
    }

    public boolean deleteOne(long id) {
        return profileMapper.deleteOne("id", id) > 0;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileMapper.deleteOne("person_id", id) > 0;
    }

    public boolean updateOne(ProfilePO profile) {
        return profileMapper.updateOne(profile) > 0;
    }

    public boolean updateMany(List<ProfilePO> profiles) {
        if (profiles == null || profiles.isEmpty()) {
            return true;
        }
        return profileMapper.updateMany(profiles) > 0;
    }

    public List<ProfilePO> getAll() {
        return profileMapper.getAll();
    }

    public List<ProfilePO> getByPersonId(Long personId) {
        return profileMapper.getByPersonId(personId);
    }

    public ProfilePO getOneById(Long id) {
        return profileMapper.getOneById(id);
    }

}
