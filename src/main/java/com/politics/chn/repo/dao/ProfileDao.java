package com.politics.chn.repo.dao;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.model.domain.entity.ProfileDO;
import com.politics.chn.model.po.ProfilePO;
import com.politics.chn.repo.dao.mapper.ProfileMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
        ProfilePO profilePO = profileDO2PO(profileDO);
        int result = profileMapper.insertOne(profilePO);
        if (result > 0) {
            profileDO.setId(profilePO.getId());
            return true;
        }
        return false;
    }

    public boolean addMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDO2PO(profileDOs);
        int result = profileMapper.insertMany(profilePOS);
        if (result == profileDOs.size()) {
            AtomicInteger index = new AtomicInteger();
            profilePOS.forEach(profilePO -> profileDOs.get(index.getAndIncrement()).setId(profilePO.getId()));
            return true;
        }
        return false;
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
        ProfilePO profilePO = profileDO2PO(profileDO);
        return profileMapper.updateOne(profilePO) > 0;
    }

    public boolean updateMany(List<ProfileDO> profileDOs) {
        if (profileDOs == null || profileDOs.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDO2PO(profileDOs);
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

    // TODO: 再考虑如何转换
    private ProfilePO profileDO2PO(ProfileDO profileDO) {
        ProfilePO profilePO = new ProfilePO();
        BeanUtil.copyProperties(profileDO, profilePO);
        if (profileDO.getDistrict() != null) {
            profilePO.setDistrictId(profileDO.getDistrict().getId());
        }
        if (profileDO.getPit() != null) {
            profilePO.setPitId(profileDO.getPit().getId());
        }
        if (profileDO.getCarrot() != null) {
            profilePO.setCarrotId(profileDO.getCarrot().getId());
        }

        return profilePO;
    }

    // TODO: 再考虑如何转换
    private List<ProfilePO> profileDO2PO(List<ProfileDO> profileDOS) {
        List<ProfilePO> profilePOS = new ArrayList<>();
        if (profileDOS == null) {
            return profilePOS;
        }
        profileDOS.forEach(profileDO -> profilePOS.add(profileDO2PO(profileDO)));
        return profilePOS;
    }

}
