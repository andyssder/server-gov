package com.politics.chn.service;

import com.politics.chn.common.exception.CommonException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:03
 */
@SpringBootTest
class DistrictServiceTest {

    private DistrictService districtService;

    @Autowired
    private void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    @Test
    void getProvincesTest() {
        Assertions.assertEquals(34, districtService.getProvinces().size(), "获取省份错误");
    }

    @Test
    void getCitiesTest() {
        Assertions.assertThrows(CommonException.class, () -> districtService.getCities(null), "获取城市异常参数错误");
        Assertions.assertNotEquals(0, districtService.getCities(1).size(), "获取城市出错");
    }
}