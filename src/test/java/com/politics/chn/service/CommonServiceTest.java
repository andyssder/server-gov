package com.politics.chn.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@SpringBootTest
class CommonServiceTest {

    private CommonService commonService;

    @Autowired
    private void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    @Test
    void getEthnicityList() {
        Assertions.assertEquals(56, commonService.getEthnicityList().size(), "查询民族出错");
    }

    @Test
    void getPartyList() {
        Assertions.assertEquals(9, commonService.getPartyList().size(), "查询party出错");
    }
}