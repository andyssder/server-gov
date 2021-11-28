package com.politics.chn.service;

import com.politics.chn.application.OfficialBiz;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @since 2021-02-20
 * @author andyssder
 */
//@SpringBootTest
class OfficialBizTest {

    private OfficialBiz officialBiz;

    @Autowired
    private void setOfficialService(OfficialBiz officialBiz) {
        this.officialBiz = officialBiz;
    }

    @Test
    void getOfficialList() {
    }

    @Test
    void getOneOfficial() {
    }

    @Test
    void addOfficial() {
    }

    @Test
    void updateOfficial() {
    }

    @Test
    void deleteOfficial() {
    }
}