package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.official.dao.PitDao;
import com.politics.chn.repo.official.repository.PitRepositoryImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @since 2021-02-16
 * @author andyssder
 */
//@SpringBootTest
class PitRepositoryImplTest {

    private PitRepositoryImpl pitRepositoryImpl;
    private PitDao pitDao;

    @Autowired
    private void setPitRepository(PitRepositoryImpl pitRepositoryImpl) {
        this.pitRepositoryImpl = pitRepositoryImpl;
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

//    @Test
//    void getChildren() {
//
//        Pit newPit1 = new Pit();
//        newPit1.setPid(1L);
//        newPit1.setName("test-getChildren1");
//        newPit1.setLevel(100);
//        newPit1.setRanking(1);
//        newPit1.setDistrictLevel(10);
//        newPit1.setLft(10000000);
//        newPit1.setRgt(10000003);
//        pitRepository.insertOne(newPit1);
//        long id1 = newPit1.getId();
//
//        Pit newPit2 = new Pit();
//        newPit2.setPid(id1);
//        newPit2.setName("test-getChildren2");
//        newPit2.setLevel(101);
//        newPit2.setRanking(2);
//        newPit2.setDistrictLevel(11);
//        newPit2.setLft(10000001);
//        newPit2.setRgt(10000002);
//        pitRepository.insertOne(newPit2);
//        long id2 = newPit2.getId();
//
//        Assertions.assertEquals(1, pitRepository.getChildren(id1).size(),"查询子记录出错");
//        pitDao.deleteOne(id1, true);
//        pitDao.deleteOne(id2, true);
//    }
//
//    @Test
//    void getOneById() {
//    }
//
//    @Test
//    void insertOne() {
//        Pit newPit = new Pit();
//        newPit.setPid(1L);
//        newPit.setName("test-getChildren1");
//        newPit.setLevel(100);
//        newPit.setRanking(1);
//        newPit.setDistrictLevel(10);
//        newPit.setLft(10000000);
//        newPit.setRgt(10000003);
//        Assertions.assertTrue(pitRepository.insertOne(newPit),"插入记录出错");
//        long id = newPit.getId();
//        pitDao.deleteOne(id, true);
//    }

    @Test
    void updateOne() {
    }

    @Test
    void deleteOne() {
    }
}