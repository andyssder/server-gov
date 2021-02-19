package com.politics.chn.repo.repository;

import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.PitDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: andyssder
 * @create: 2021-02-16 10:58
 */
@SpringBootTest
class PitRepositoryTest {

    private PitRepository pitRepository;
    private PitDao pitDao;

    @Autowired
    private void setPitRepository(PitRepository pitRepository) {
        this.pitRepository = pitRepository;
    }

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    @Test
    void getAll() {

    }

    @Test
    void getByDistrictLevel() {

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
        pitRepository.insertOne(pitPO1);

        PitPO pitPO2 = new PitPO();
        pitPO2.setPid(pitPO1.getId());
        pitPO2.setName("test-getChildren2");
        pitPO2.setLevel(101);
        pitPO2.setRank(2);
        pitPO2.setDistrictLevel(11);
        pitPO2.setLft(10000001);
        pitPO2.setRgt(10000002);
        pitRepository.insertOne(pitPO2);

        Assertions.assertEquals(1, pitRepository.getChildren(pitPO1.getId()).size(),"查询子记录出错");
        pitDao.deleteOne(pitPO1.getId(), true);
        pitDao.deleteOne(pitPO2.getId(), true);
    }

    @Test
    void getOneById() {
    }

    @Test
    void insertOne() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}