package com.politics.chn.repo.dao;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.ProfileDO;
import com.politics.chn.repo.dao.mapper.ProfileMapper;
import com.politics.chn.repo.po.ProfilePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public boolean addOne(ProfileDO profileDO) {
        return profileMapper.insertOne(transfer(profileDO)) > 0;
    }

    public boolean addMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDOs.stream().map(item -> transfer(item)).collect(Collectors.toList());
        int result = profileMapper.insertMany(profilePOS);
        return result == profileDOs.size();
    }

    public boolean deleteOne(long id) {
        return profileMapper.deleteOne("id", id) > 0;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileMapper.deleteOne("person_id", id) > 0;
    }

    public boolean updateOne(ProfileDO profileDO) {
        return profileMapper.updateOne(transfer(profileDO)) > 0;
    }

    public boolean updateMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDOs.stream().map(item -> transfer(item)).collect(Collectors.toList());
        return profileMapper.updateMany(profilePOS) > 0;
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

    private ProfilePO transfer(ProfileDO profileDO) {
        ProfilePO profilePO = BeanUtil.copyProperties(profileDO, ProfilePO.class, "district");
        if (profileDO.getDistrict() != null) {
            profilePO.setDistrict(profileDO.getDistrict().getId());
        }
        return profilePO;
    }

}
