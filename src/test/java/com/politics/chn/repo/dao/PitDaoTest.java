package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.model.po.PitPO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andyssder
 * @create 2021-02-15 18:26
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
        Assertions.assertNotEquals(0, pitDao.getAll().size(), "查询单位信息出错");
    }

    @Test
    void getByDistrictLevel() {
        PitPO pitPO1 = new PitPO();
        pitPO1.setPid(1L);
        pitPO1.setName("test-getByDistrictLevel1");
        pitPO1.setLevel(100);
        pitPO1.setRank(1);
        pitPO1.setDistrictLevel(10);
        pitPO1.setLft(10000000);
        pitPO1.setRgt(10000003);
        pitDao.insertOne(pitPO1);

        PitPO pitPO2 = new PitPO();
        pitPO2.setPid(pitPO1.getId());
        pitPO2.setName("test-getByDistrictLevel2");
        pitPO2.setLevel(101);
        pitPO2.setRank(2);
        pitPO2.setDistrictLevel(11);
        pitPO2.setLft(10000001);
        pitPO2.setRgt(10000002);
        pitDao.insertOne(pitPO2);

        Assertions.assertEquals(1, pitDao.getByDistrictLevel(10).size(),"根据地区级别查询记录出错");
        Assertions.assertEquals(1, pitDao.getByDistrictLevel(11).size(),"根据地区级别查询记录出错");
        pitDao.deleteOne(pitPO1.getId(), true);
        pitDao.deleteOne(pitPO2.getId(), true);
    }

    @Test
    void getChildren() {
        PitPO pitPO1 = new PitPO();
        pitPO1.setPid(1L);
        pitPO1.setName("test-getChildren1");
        pitPO1.setLevel(100);
        pitPO1.setRank(1);
        pitPO1.setDistrictLevel(10);
        pitPO1.setLft(10000000);
        pitPO1.setRgt(10000003);
        pitDao.insertOne(pitPO1);

        PitPO pitPO2 = new PitPO();
        pitPO2.setPid(pitPO1.getId());
        pitPO2.setName("test-getChildren2");
        pitPO2.setLevel(101);
        pitPO2.setRank(2);
        pitPO2.setDistrictLevel(11);
        pitPO2.setLft(10000001);
        pitPO2.setRgt(10000002);
        pitDao.insertOne(pitPO2);

        Assertions.assertEquals(1, pitDao.getChildren(10000000, 10000003, 100).size(),"查询子记录出错");
        pitDao.deleteOne(pitPO1.getId(), true);
        pitDao.deleteOne(pitPO2.getId(), true);
    }

    @Test
    void getOneById() {
        PitPO pitPO = new PitPO();
        pitPO.setPid(1L);
        pitPO.setName("test-getOneById");
        pitPO.setLevel(1);
        pitPO.setRank(1);
        pitPO.setDistrictLevel(1);
        pitPO.setLft(1);
        pitPO.setRgt(100);

        pitDao.insertOne(pitPO);
        Assertions.assertEquals(pitPO, pitDao.getOneById(pitPO.getId()));
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void insertOne() {
        PitPO pitPO = new PitPO();
        pitPO.setPid(1L);
        pitPO.setName("test-insertOne");
        pitPO.setLevel(1);
        pitPO.setRank(1);
        pitPO.setDistrictLevel(1);
        pitPO.setLft(1);
        pitPO.setRgt(100);
        Assertions.assertTrue(pitDao.insertOne(pitPO),"插入记录错误");
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void updateOne() {
        PitPO pitPO = new PitPO();
        pitPO.setPid(1L);
        pitPO.setName("test-updateOne");
        pitPO.setLevel(1);
        pitPO.setRank(1);
        pitPO.setDistrictLevel(1);
        pitPO.setLft(1);
        pitPO.setRgt(100);

        PitPO targetPitPO = new PitPO();
        targetPitPO.setName("test-updated");
        
        pitDao.insertOne(pitPO);
        targetPitPO.setId(pitPO.getId());

        Assertions.assertTrue(pitDao.updateOne(targetPitPO),"修改记录错误");
        PitDO updatedPitDO = pitDao.getOneById(pitPO.getId());
        Assertions.assertEquals(targetPitPO.getName(), updatedPitDO.getName(),"修改内容不匹配");
        pitDao.deleteOne(pitPO.getId(), true);
    }

    @Test
    void deleteOne() {
        PitPO pitPO = new PitPO();
        pitPO.setPid(1L);
        pitPO.setName("test-delete");
        pitPO.setLevel(1);
        pitPO.setRank(1);
        pitPO.setDistrictLevel(1);
        pitPO.setLft(1);
        pitPO.setRgt(100);
        pitDao.insertOne(pitPO);
        Assertions.assertTrue(pitDao.deleteOne(pitPO.getId()));
        pitDao.deleteOne(pitPO.getId(), true);
    }
}