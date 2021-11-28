package com.politics.chn.repo.user.dao;

import cn.hutool.core.date.DateUtil;
import com.politics.chn.domain.official.entity.ProfileDO;
import com.politics.chn.repo.official.dao.ProfileDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
//@SpringBootTest
class ProfileDaoTest {

    private ProfileDao profileDao;

    @Autowired
    private void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

//    @Test
//    void addOne() {
//        ProfileDO profile = getProfileDO();
//        Assertions.assertTrue(profileDao.addOne(profile), "插入profile失败");
//
//        profileDao.deleteOne(profile.getId());
//    }
//
//    @Test
//    void addMany() {
//        List<ProfileDO> profiles = getProfileDOList();
//
//        Assertions.assertTrue(profileDao.addMany(profiles), "批量插入profile失败");
//
//        profileDao.deleteOneByPersonId(profiles.get(0).getPersonId());
//    }
//
//    @Test
//    void deleteOne() {
//        ProfileDO profile = getProfileDO();
//        profileDao.addOne(profile);
//        Long id = profile.getId();
//        Assertions.assertTrue(profileDao.deleteOne(id), "删除profile错误");
//        Assertions.assertTrue(profileDao.getOneById(id).getDeleted(), "标记删除profile错误");
//        profileDao.deleteOne(id);
//    }
//
//    @Test
//    void deleteOneByPersonId() {
//        ProfileDO profile = getProfileDO();
//        profileDao.addOne(profile);
//        Long personId = profile.getPersonId();
//        Assertions.assertTrue(profileDao.deleteOneByPersonId(personId), "根据personId删除profile错误");
//        Assertions.assertTrue(profileDao.getOneByPersonId(personId).get(0).getDeleted(), "根据personId标记删除profile错误");
//        profileDao.deleteOneByPersonId(personId);
//    }
//
//    @Test
//    void updateOne() {
//        ProfileDO profile = getProfileDO();
//        profileDao.addOne(profile);
//        profile.setRemark("remark");
//        Assertions.assertTrue(profileDao.updateOne(profile), "更新profile失败");
//        Long id = profile.getId();
//        ProfileDO updatedProfileDO = profileDao.getOneById(id);
//        Assertions.assertEquals(profile.getRemark(), updatedProfileDO.getRemark(),"更新profile内容检验失败");
//
//        profileDao.deleteOne(id);
//    }
//
//    @Test
//    void updateMany() {
//        List<ProfileDO> profiles = getProfileDOList();
//        profileDao.addMany(profiles);
//        profiles.forEach(profile -> profile.setRemark("remark"));
//
//        Assertions.assertTrue(profileDao.updateMany(profiles), "批量更新profile失败");
//
//        profiles.forEach(profile -> {
//            ProfileDO updatedProfile = profileDao.getOneById(profile.getId());
//            Assertions.assertEquals(profile.getRemark(),updatedProfile.getRemark(), "批量更新profile失败内容校验");
//        });
//
//        profileDao.deleteOneByPersonId(profiles.get(0).getPersonId());
//
//    }
//
//    @Test
//    void getAll() {
//
//    }
//
//    @Test
//    void getOneByPersonId() {
//        List<ProfileDO> profiles = getProfileDOList();
//        profileDao.addMany(profiles);
//        Long personId = profiles.get(0).getPersonId();
//        Assertions.assertEquals(profiles.size(), profileDao.getOneByPersonId(personId).size(), "根据personId获取profile失败");
//        profileDao.deleteOneByPersonId(personId);
//    }
//
//    @Test
//    void getOneById() {
//    }
//
//    private ProfileDO getProfileDO () {
//        ProfileDO profileDO = new ProfileDO();
//        Date date = DateUtil.parse(DateUtil.today());
//        profileDO.setStartTime(date);
//        profileDO.setPersonId(10000000L);
////        DistrictPO district = 1;
////        profileDO.setDistrict(district);
//        Long pit = 1L;
//        profileDO.setPit(pit);
//        Long carrot = 40L;
//        profileDO.setCarrot(carrot);
//
//        return profileDO;
//    }
//
//    private List<ProfileDO> getProfileDOList() {
//        List<ProfileDO> result = new ArrayList<>();
//        result.add(getProfileDO());
//        result.add(getProfileDO());
//        return result;
//    }
}