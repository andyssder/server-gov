package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.official.repository.DistrictRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @since 2021-02-08
 * @author andyssder
 */
//@SpringBootTest
class DistrictRepositoryTest {

    private DistrictRepository districtRepository;

    @Autowired
    private void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    @Test
    void getByID() {
        Assertions.assertNotNull(districtRepository.getById(1), "通过id查询错误");
    }

    @Test
    void getByLevel() {
        Assertions.assertNotNull(districtRepository.getByLevel(1), "通过level查询错误");
    }

    @Test
    void getChildrenById() {
        Assertions.assertNotEquals(0, districtRepository.getChildrenById(1).size(),"通过id查询子节点错误");
    }

    @Test
    void getParentById() {
        Assertions.assertNotEquals(0, districtRepository.getParentById(10).size(),"通过id查询父节点错误");
    }
}