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
        PitPO pitPO1 = new PitPO(1L,"test-getChildren1", "",100, 1, 1, 10000000,10000003);
        pitRepository.insertOne(pitPO1);
        PitPO pitPO2 = new PitPO(pitPO1.getId(),"test-getChildren2",101, 2, 2, 10000001,10000002);
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