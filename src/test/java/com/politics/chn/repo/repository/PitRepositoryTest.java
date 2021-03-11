package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.repo.dao.PitDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andyssder
 * @create 2021-02-16 10:58
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

        PitDO newPit1 = new PitDO();
        newPit1.setPid(1L);
        newPit1.setName("test-getChildren1");
        newPit1.setLevel(100);
        newPit1.setRank(1);
        newPit1.setDistrictLevel(10);
        newPit1.setLft(10000000);
        newPit1.setRgt(10000003);
        long id1 = pitRepository.insertOne(newPit1);

        PitDO newPit2 = new PitDO();
        newPit2.setPid(id1);
        newPit2.setName("test-getChildren2");
        newPit2.setLevel(101);
        newPit2.setRank(2);
        newPit2.setDistrictLevel(11);
        newPit2.setLft(10000001);
        newPit2.setRgt(10000002);
        long id2 = pitRepository.insertOne(newPit2);

        Assertions.assertEquals(1, pitRepository.getChildren(id1).size(),"查询子记录出错");
        pitDao.deleteOne(id1, true);
        pitDao.deleteOne(id2, true);
    }

    @Test
    void getOneById() {
    }

    @Test
    void insertOne() {
        PitDO newPit = new PitDO();
        newPit.setPid(1L);
        newPit.setName("test-getChildren1");
        newPit.setLevel(100);
        newPit.setRank(1);
        newPit.setDistrictLevel(10);
        newPit.setLft(10000000);
        newPit.setRgt(10000003);
        long id = pitRepository.insertOne(newPit);
        Assertions.assertNotNull(id,"插入记录出错");
        pitDao.deleteOne(id, true);
    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}