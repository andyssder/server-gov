package com.politics.chn.repo.dao;

import com.politics.chn.model.po.PitPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author: andyssder
 * @create: 2021-02-15 18:26
 */
@SpringBootTest
class PitDaoTest {

    private PitDao pitDao;

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    @Test
    void getAll() {
        List<PitPO> pitPOs = pitDao.getAll();
        Assertions.assertNotEquals(0, pitPOs.size(), "查询单位信息出错");
    }

    @Test
    void getByDistrictLevel() {
        PitPO pitPO1 = new PitPO(1L,"test-getByDistrictLevel1", "",100, 1, 10, 10000000,10000003);
        pitDao.insertOne(pitPO1);
        PitPO pitPO2 = new PitPO(pitPO1.getId(),"test-getByDistrictLevel2",101, 2, 11, 10000001,10000002);
        pitDao.insertOne(pitPO2);
        Assertions.assertEquals(1, pitDao.getByDistrictLevel(10).size(),"根据地区级别查询记录出错");
        Assertions.assertEquals(1, pitDao.getByDistrictLevel(11).size(),"根据地区级别查询记录出错");
        pitDao.deleteOne(pitPO1.getId(), true);
        pitDao.deleteOne(pitPO2.getId(), true);
    }

    @Test
    void getChildren() {
        PitPO pitPO1 = new PitPO(1L,"test-getChildren1", "",100, 1, 10, 10000000,10000003);
        pitDao.insertOne(pitPO1);
        PitPO pitPO2 = new PitPO(pitPO1.getId(),"test-getChildren2",101, 2, 11, 10000001,10000002);
        pitDao.insertOne(pitPO2);
        Assertions.assertEquals(1, pitDao.getChildren(10000000, 10000003, 100).size(),"查询子记录出错");
        pitDao.deleteOne(pitPO1.getId(), true);
        pitDao.deleteOne(pitPO2.getId(), true);
    }

    @Test
    void getOneById() {
        PitPO pitPO = new PitPO(1L,"test-getOneById", "",1, 1, 1, 1, 100);
        pitDao.insertOne(pitPO);
        Assertions.assertEquals(pitPO, pitDao.getOneById(pitPO.getId()));
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void insertOne() {
        PitPO pitPO = new PitPO(1L,"test-insertOne", "",1, 1, 1, 1, 100);
        Assertions.assertTrue(pitDao.insertOne(pitPO),"插入记录错误");
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void updateOne() {
        PitPO pitPO = new PitPO(1L,"test-updateOne", "",1, 1, 1, 1, 100);
        PitPO targetPitPO = new PitPO(1L,"test-updated", "test",2, 1, 1, 1, 100);
        pitDao.insertOne(pitPO);
        targetPitPO.setId(pitPO.getId());
        Map<String, Object> params = new HashMap<>();
        params.put("name", targetPitPO.getName());
        params.put("short_name", targetPitPO.getShortName());
        params.put("level", targetPitPO.getLevel());
        Assertions.assertTrue(pitDao.updateOne(pitPO.getId(), params),"修改记录错误");
        PitPO updatedPitPO = pitDao.getOneById(pitPO.getId());
        Assertions.assertEquals(targetPitPO, updatedPitPO,"修改内容不匹配");
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void deleteOne() {
        PitPO pitPO = new PitPO(1L,"delete-test", "",1, 1, 1, 0, 0);
        pitDao.insertOne(pitPO);
        Assertions.assertTrue(pitDao.deleteOne(pitPO.getId()));
        pitDao.deleteOne(pitPO.getId(), true);
    }
}