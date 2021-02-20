package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.CarrotDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andyssder
 * @create 2021-02-18 12:13
 */
@SpringBootTest
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

    @Test
    void getByPitLevel() {
        CarrotDO CarrotDO1 = new CarrotDO();
        CarrotDO1.setName("test-getByPitLevel1");
        CarrotDO1.setPitLevel(10);
        CarrotDO CarrotDO2 = new CarrotDO();
        CarrotDO2.setName("test-getByPitLevel2");
        CarrotDO2.setPitLevel(11);
        carrotDao.insertOne(CarrotDO1);
        carrotDao.insertOne(CarrotDO2);
        Assertions.assertEquals(1, carrotDao.getByPitLevel(10).size(),"根据pit级别查询记录出错");
        Assertions.assertEquals(1, carrotDao.getByPitLevel(11).size(),"根据pit级别查询记录出错");
        carrotDao.deleteOne(CarrotDO1.getId(), true);
        carrotDao.deleteOne(CarrotDO2.getId(), true);
    }

    @Test
    void getOneById() {
        CarrotDO CarrotDO = new CarrotDO();
        CarrotDO.setName("test-getOneById");
        CarrotDO.setPitLevel(1);
        CarrotDO.setDeleted(false);
        carrotDao.insertOne(CarrotDO);
        Assertions.assertEquals(CarrotDO, carrotDao.getOneById(CarrotDO.getId()));
        carrotDao.deleteOne(CarrotDO.getId(), true);
    }

    @Test
    void insertOne() {
        CarrotDO CarrotDO = new CarrotDO();
        CarrotDO.setName("test-insertOne");
        CarrotDO.setPitLevel(1);
        Assertions.assertTrue(carrotDao.insertOne(CarrotDO),"插入记录错误");
        carrotDao.deleteOne(CarrotDO.getId(), true);
    }

    @Test
    void updateOne() {
        CarrotDO CarrotDO = new CarrotDO();
        CarrotDO.setName("test-updateOne");
        CarrotDO.setPitLevel(1);
        carrotDao.insertOne(CarrotDO);

        CarrotDO targetCarrotDO = new CarrotDO();
        targetCarrotDO.setName("test-updateOne");
        targetCarrotDO.setShortName("test");
        targetCarrotDO.setPitLevel(1);
        targetCarrotDO.setId(CarrotDO.getId());
        targetCarrotDO.setDeleted(false);

        Assertions.assertTrue(carrotDao.updateOne(targetCarrotDO),"修改记录错误");
        CarrotDO updatedCarrotDO = carrotDao.getOneById(CarrotDO.getId());
        Assertions.assertEquals(targetCarrotDO, updatedCarrotDO,"修改内容不匹配");
        carrotDao.deleteOne(CarrotDO.getId(), true);
    }

}