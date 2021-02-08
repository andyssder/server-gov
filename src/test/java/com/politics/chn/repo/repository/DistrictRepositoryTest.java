package com.politics.chn.repo.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: andyssder
 * @create: 2021-02-08 16:38
 */
@SpringBootTest
class DistrictRepositoryTest {

    private DistrictRepository districtRepository;

    @Autowired
    public void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Test
    void getByIDTest() {
        Assertions.assertNotNull(districtRepository.getByID(1), "通过id查询错误");
    }

    @Test
    void getByLevelTest() {
        Assertions.assertNotNull(districtRepository.getByLevel(1), "通过level查询错误");
    }

    @Test
    void getChildrenByIdTest() {
        Assertions.assertNotEquals(0, districtRepository.getChildrenById(1).size(),"通过id查询子节点错误");
    }

    @Test
    void getParentByIdTest() {
        Assertions.assertNotEquals(0, districtRepository.getParentById(10).size(),"通过id查询父节点错误");
    }
}