package com.politics.chn.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@SpringBootTest
class OfficialServiceTest {

    private OfficialService officialService;

    @Autowired
    private void setOfficialService(OfficialService officialService) {
        this.officialService = officialService;
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