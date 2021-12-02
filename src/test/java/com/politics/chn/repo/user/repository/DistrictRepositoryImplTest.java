package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.official.repository.DistrictRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @since 2021-02-08
 * @author andyssder
 */
//@SpringBootTest
class DistrictRepositoryImplTest {

    private DistrictRepositoryImpl districtRepositoryImpl;

    @Autowired
    private void setDistrictRepository(DistrictRepositoryImpl districtRepositoryImpl) {
        this.districtRepositoryImpl = districtRepositoryImpl;
    }

    @Test
    void getByID() {
        Assertions.assertNotNull(districtRepositoryImpl.getById(1), "通过id查询错误");
    }

    @Test
    void getByLevel() {
        Assertions.assertNotNull(districtRepositoryImpl.getByLevel(1), "通过level查询错误");
    }

    @Test
    void getChildrenById() {
        Assertions.assertNotEquals(0, districtRepositoryImpl.getChildrenById(1).size(),"通过id查询子节点错误");
    }

    @Test
    void getParentById() {
        Assertions.assertNotEquals(0, districtRepositoryImpl.getParentById(10).size(),"通过id查询父节点错误");
    }
}