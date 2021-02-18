package com.politics.chn.repo.dao;

import com.politics.chn.model.po.CarrotPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


/**
 * @author: andyssder
 * @create: 2021-02-18 12:13
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
        CarrotPO carrotPO1 = new CarrotPO("test-getByPitLevel1", "",10);
        CarrotPO carrotPO2 = new CarrotPO("test-getByPitLevel2", "",11);
        carrotDao.insertOne(carrotPO1);
        carrotDao.insertOne(carrotPO2);
        Assertions.assertEquals(1, carrotDao.getByPitLevel(10).size(),"根据pit级别查询记录出错");
        Assertions.assertEquals(1, carrotDao.getByPitLevel(11).size(),"根据pit级别查询记录出错");
        carrotDao.deleteOne(carrotPO1.getId());
        carrotDao.deleteOne(carrotPO1.getId());
    }

    @Test
    void getOneById() {
        CarrotPO carrotPO = new CarrotPO("test-getOneById", "",1);
        carrotDao.insertOne(carrotPO);
        Assertions.assertEquals(carrotPO, carrotDao.getOneById(carrotPO.getId()));
        carrotDao.deleteOne(carrotPO.getId());
    }

    @Test
    void insertOne() {
        CarrotPO carrotPO = new CarrotPO("test-insertOne", "",1);
        Assertions.assertTrue(carrotDao.insertOne(carrotPO),"插入记录错误");
        carrotDao.deleteOne(carrotPO.getId());
    }

    @Test
    void updateOne() {
        CarrotPO carrotPO = new CarrotPO("test-updateOne", "",1);
        CarrotPO targetCarrotPO = new CarrotPO("test-updated", "test",1);
        carrotDao.insertOne(carrotPO);
        targetCarrotPO.setId(carrotPO.getId());
        Map<String, Object> params = new HashMap<>();
        params.put("name", targetCarrotPO.getName());
        params.put("short_name", targetCarrotPO.getShortName());
        Assertions.assertTrue(carrotDao.updateOne(carrotPO.getId(), params),"修改记录错误");
        CarrotPO updatedCarrotPO = carrotDao.getOneById(carrotPO.getId());
        Assertions.assertEquals(targetCarrotPO, updatedCarrotPO,"修改内容不匹配");
        carrotDao.deleteOne(carrotPO.getId());
    }

}