package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.official.dao.ProfileDao;
import org.springframework.beans.factory.annotation.Autowired;

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
//        Profile profile = getProfileDO();
//        Assertions.assertTrue(profileDao.addOne(profile), "插入profile失败");
//
//        profileDao.deleteOne(profile.getId());
//    }
//
//    @Test
//    void addMany() {
//        List<Profile> profiles = getProfileDOList();
//
//        Assertions.assertTrue(profileDao.addMany(profiles), "批量插入profile失败");
//
//        profileDao.deleteOneByPersonId(profiles.get(0).getPersonId());
//    }
//
//    @Test
//    void deleteOne() {
//        Profile profile = getProfileDO();
//        profileDao.addOne(profile);
//        Long id = profile.getId();
//        Assertions.assertTrue(profileDao.deleteOne(id), "删除profile错误");
//        Assertions.assertTrue(profileDao.getOneById(id).getDeleted(), "标记删除profile错误");
//        profileDao.deleteOne(id);
//    }
//
//    @Test
//    void deleteOneByPersonId() {
//        Profile profile = getProfileDO();
//        profileDao.addOne(profile);
//        Long personId = profile.getPersonId();
//        Assertions.assertTrue(profileDao.deleteOneByPersonId(personId), "根据personId删除profile错误");
//        Assertions.assertTrue(profileDao.getOneByPersonId(personId).get(0).getDeleted(), "根据personId标记删除profile错误");
//        profileDao.deleteOneByPersonId(personId);
//    }
//
//    @Test
//    void updateOne() {
//        Profile profile = getProfileDO();
//        profileDao.addOne(profile);
//        profile.setRemark("remark");
//        Assertions.assertTrue(profileDao.updateOne(profile), "更新profile失败");
//        Long id = profile.getId();
//        Profile updatedProfileDO = profileDao.getOneById(id);
//        Assertions.assertEquals(profile.getRemark(), updatedProfileDO.getRemark(),"更新profile内容检验失败");
//
//        profileDao.deleteOne(id);
//    }
//
//    @Test
//    void updateMany() {
//        List<Profile> profiles = getProfileDOList();
//        profileDao.addMany(profiles);
//        profiles.forEach(profile -> profile.setRemark("remark"));
//
//        Assertions.assertTrue(profileDao.updateMany(profiles), "批量更新profile失败");
//
//        profiles.forEach(profile -> {
//            Profile updatedProfile = profileDao.getOneById(profile.getId());
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
//        List<Profile> profiles = getProfileDOList();
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
//    private Profile getProfileDO () {
//        Profile profileDO = new Profile();
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
//    private List<Profile> getProfileDOList() {
//        List<Profile> result = new ArrayList<>();
//        result.add(getProfileDO());
//        result.add(getProfileDO());
//        return result;
//    }
}