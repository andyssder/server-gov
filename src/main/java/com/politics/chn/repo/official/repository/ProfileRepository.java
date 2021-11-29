package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.ProfileDO;
import com.politics.chn.repo.official.dao.ProfileDao;
import com.politics.chn.repo.official.po.ProfilePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */

@Repository
public class ProfileRepository {

    private ProfileDao profileDao;

    @Autowired
    public void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    public boolean addOne(ProfileDO profileDO) {
        ProfilePO profilePO = BeanUtil.toBean(profileDO, ProfilePO.class);
        if(!profileDao.addOne(profilePO)) {;
            return false;
        }
        profileDO.setId(profilePO.getId());
        return true;
    }

    public boolean addMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDOS.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfilePO.class)).collect(Collectors.toList());

        return profileDao.addMany(profilePOS);
    }

    public boolean deleteOne(long id) {
        return profileDao.deleteOne(id) ;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileDao.deleteOneByPersonId(id);
    }

    public boolean updateOne(ProfileDO profileDO) {
        ProfilePO profilePO = BeanUtil.toBean(profileDO, ProfilePO.class);
        return profileDao.updateOne(profilePO);
    }

    public boolean updateMany(List<ProfileDO> profileDOS) {
        if (profileDOS == null || profileDOS.isEmpty()) {
            return true;
        }
        List<ProfilePO> profilePOS = profileDOS.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfilePO.class)).collect(Collectors.toList());
        return profileDao.updateMany(profilePOS);
    }

    public List<ProfilePO> getAll() {
        return profileDao.getAll();
    }

    public List<ProfileDO> getOneByPersonId(Long personId) {
        List<ProfilePO> list = profileDao.getOneByPersonId(personId);
        return list.stream().map(profileDO -> BeanUtil.toBean(profileDO, ProfileDO.class)).collect(Collectors.toList());
    }

    public ProfileDO getOneById(Long id) {
        ProfilePO profilePO = profileDao.getOneById(id);
        return BeanUtil.toBean(profilePO, ProfileDO.class);
    }
}
