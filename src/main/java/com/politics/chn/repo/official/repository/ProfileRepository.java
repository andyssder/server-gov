package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
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

    public boolean addOne(ProfilePO profilePO) {
        return profileDao.addOne(profilePO);
    }

    public boolean addMany(List<ProfilePO> profilePOS) {
        if (profilePOS == null || profilePOS.isEmpty()) {
            return true;
        }
        return profileDao.addMany(profilePOS);
    }

    public boolean deleteOne(long id) {
        return profileDao.deleteOne(id) ;
    }

    public boolean deleteOneByPersonId(long id) {
        return profileDao.deleteOneByPersonId(id);
    }

    public boolean updateOne(ProfilePO profilePO) {
        return profileDao.updateOne(profilePO);
    }

    public boolean updateMany(List<ProfilePO> profiles) {
        if (profiles == null || profiles.isEmpty()) {
            return true;
        }
        return profileDao.updateMany(profiles);
    }

    public List<ProfilePO> getAll() {
        return profileDao.getAll();
    }

    public List<ProfilePO> getOneByPersonId(Long personId) {
        return profileDao.getOneByPersonId(personId);
    }

    public ProfilePO getOneById(Long id) {
        return profileDao.getOneById(id);
    }
}
