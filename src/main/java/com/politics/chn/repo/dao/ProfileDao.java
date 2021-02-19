package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.model.po.PersonPO;
import com.politics.chn.model.po.ProfilePO;
import com.politics.chn.repo.dao.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public boolean addOne(ProfilePO profilePO) {
        return profileMapper.insertOne(profilePO) > 0;
    }

    public boolean updateOne(long id, Map<String, Object> updateParams) {
        return profileMapper.updateOne(id, updateParams) > 0;
    }

    public List<ProfileDO> getAll() {
        return profileMapper.getAll();
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        String field = "id";
        return realDelete ? profileMapper.realDeleteOne(field, id) > 0 : profileMapper.deleteOne(field, id) > 0;
    }

    public boolean deleteOneByPersonId(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOneByPersonId(long id, boolean realDelete) {
        String field = "person_id";
        return realDelete ? profileMapper.realDeleteOne(field, id) > 0 : profileMapper.deleteOne(field, id) > 0;
    }
}
