package com.politics.chn.repo.dao;

import com.politics.chn.domain.official.value.PitDO;
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
        PitDO pit1 = new PitDO();
        pit1.setPid(1L);
        pit1.setName("test-getByDistrictLevel1");
        pit1.setLevel(100);
        pit1.setRanking(1);
        pit1.setDistrictLevel(10);
        pit1.setLft(10000000);
        pit1.setRgt(10000003);
        pitDao.insertOne(pit1);

        PitDO pit2 = new PitDO();
        pit2.setPid(pit1.getId());
        pit2.setName("test-getByDistrictLevel2");
        pit2.setLevel(101);
        pit2.setRanking(2);
        pit2.setDistrictLevel(11);
        pit2.setLft(10000001);
        pit2.setRgt(10000002);
        pitDao.insertOne(pit2);

        Assertions.assertEquals(1, pitDao.getByDistrictLevel(10).size(),"根据地区级别查询记录出错");
        Assertions.assertEquals(1, pitDao.getByDistrictLevel(11).size(),"根据地区级别查询记录出错");
        pitDao.deleteOne(pit1.getId(), true);
        pitDao.deleteOne(pit2.getId(), true);
    }

    @Test
    void getChildren() {
        PitDO pit1 = new PitDO();
        pit1.setPid(1L);
        pit1.setName("test-getChildren1");
        pit1.setLevel(100);
        pit1.setRanking(1);
        pit1.setDistrictLevel(10);
        pit1.setLft(10000000);
        pit1.setRgt(10000003);
        pitDao.insertOne(pit1);

        PitDO pit2 = new PitDO();
        pit2.setPid(pit1.getId());
        pit2.setName("test-getChildren2");
        pit2.setLevel(101);
        pit2.setRanking(2);
        pit2.setDistrictLevel(11);
        pit2.setLft(10000001);
        pit2.setRgt(10000002);
        pitDao.insertOne(pit2);

        Assertions.assertEquals(1, pitDao.getChildren(10000000, 10000003, 100).size(),"查询子记录出错");
        pitDao.deleteOne(pit1.getId(), true);
        pitDao.deleteOne(pit2.getId(), true);
    }

    @Test
    void getOneById() {
        PitDO pit = new PitDO();
        pit.setPid(1L);
        pit.setName("test-getOneById");
        pit.setLevel(1);
        pit.setRanking(1);
        pit.setDistrictLevel(1);
        pit.setLft(1);
        pit.setRgt(100);
        pit.setDeleted(false);

        pitDao.insertOne(pit);
        Assertions.assertEquals(pit, pitDao.getOneById(pit.getId()));
        pitDao.deleteOne(pit.getId(), true);
    }

    @Test
    void insertOne() {
        PitDO pit = new PitDO();
        pit.setPid(1L);
        pit.setName("test-insertOne");
        pit.setLevel(1);
        pit.setRanking(1);
        pit.setDistrictLevel(1);
        pit.setLft(1);
        pit.setRgt(100);
        Assertions.assertTrue(pitDao.insertOne(pit),"插入记录错误");
        pitDao.deleteOne(pit.getId(), true);
    }

    @Test
    void updateOne() {
        PitDO pit = new PitDO();
        pit.setPid(1L);
        pit.setName("test-updateOne");
        pit.setLevel(1);
        pit.setRanking(1);
        pit.setDistrictLevel(1);
        pit.setLft(1);
        pit.setRgt(100);

        PitDO targetPit = new PitDO();
        targetPit.setName("test-updated");
        
        pitDao.insertOne(pit);
        targetPit.setId(pit.getId());

        Assertions.assertTrue(pitDao.updateOne(targetPit),"修改记录错误");
        PitDO updatedPit = pitDao.getOneById(pit.getId());
        Assertions.assertEquals(targetPit.getName(), updatedPit.getName(),"修改内容不匹配");
        pitDao.deleteOne(pit.getId(), true);
    }

    @Test
    void deleteOne() {
        PitDO pit = new PitDO();
        pit.setPid(1L);
        pit.setName("test-delete");
        pit.setLevel(1);
        pit.setRanking(1);
        pit.setDistrictLevel(1);
        pit.setLft(1);
        pit.setRgt(100);
        pitDao.insertOne(pit);
        Assertions.assertTrue(pitDao.deleteOne(pit.getId()));
        pitDao.deleteOne(pit.getId(), true);
    }
}