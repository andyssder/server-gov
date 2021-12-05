package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.official.dao.CarrotDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @since 2021-02-18
 * @author andyssder
 */
//@SpringBootTest
class CarrotDaoTest {
    private CarrotDao carrotDao;

    @Autowired
    private void setCarrotDao(CarrotDao carrotDao) {
        this.carrotDao = carrotDao;
    }

    @Test
    void getAll() {
        Assertions.assertNotNull(carrotDao.getAll(), "查询carrot信息出错");
    }

//    @Test
//    void getByDistrictLevel() {
//        Carrot CarrotDO1 = new Carrot();
//        CarrotDO1.setName("test-getByDistrictLevel1");
//        CarrotDO1.setDistrictLevel(10);
//        Carrot CarrotDO2 = new Carrot();
//        CarrotDO2.setName("test-getByDistrictLevel2");
//        CarrotDO2.setDistrictLevel(11);
//        carrotDao.insertOne(CarrotDO1);
//        carrotDao.insertOne(CarrotDO2);
//        Assertions.assertEquals(1, carrotDao.getByDistrictLevel(10).size(),"根据pit级别查询记录出错");
//        Assertions.assertEquals(1, carrotDao.getByDistrictLevel(11).size(),"根据pit级别查询记录出错");
//        carrotDao.deleteOne(CarrotDO1.getId(), true);
//        carrotDao.deleteOne(CarrotDO2.getId(), true);
//    }
//
//    @Test
//    void getOneById() {
//        Carrot Carrot = new Carrot();
//        Carrot.setName("test-getOneById");
//        Carrot.setDistrictLevel(1);
//        Carrot.setDeleted(false);
//        carrotDao.insertOne(Carrot);
//        Assertions.assertEquals(Carrot, carrotDao.getOneById(Carrot.getId()));
//        carrotDao.deleteOne(Carrot.getId(), true);
//    }
//
//    @Test
//    void insertOne() {
//        Carrot Carrot = new Carrot();
//        Carrot.setName("test-insertOne");
//        Carrot.setDistrictLevel(1);
//        Assertions.assertTrue(carrotDao.insertOne(Carrot),"插入记录错误");
//        carrotDao.deleteOne(Carrot.getId(), true);
//    }
//
//    @Test
//    void updateOne() {
//        Carrot Carrot = new Carrot();
//        Carrot.setName("test-updateOne");
//        Carrot.setDistrictLevel(1);
//        carrotDao.insertOne(Carrot);
//
//        Carrot targetCarrotDO = new Carrot();
//        targetCarrotDO.setName("test-updateOne");
//        targetCarrotDO.setShortName("test");
//        targetCarrotDO.setDistrictLevel(1);
//        targetCarrotDO.setId(Carrot.getId());
//        targetCarrotDO.setDeleted(false);
//
//        Assertions.assertTrue(carrotDao.updateOne(targetCarrotDO),"修改记录错误");
//        Carrot updatedCarrotDO = carrotDao.getOneById(Carrot.getId());
//        Assertions.assertEquals(targetCarrotDO, updatedCarrotDO,"修改内容不匹配");
//        carrotDao.deleteOne(Carrot.getId(), true);
//    }

}