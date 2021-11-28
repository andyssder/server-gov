package com.politics.chn.repo.user.repository;

import com.politics.chn.service.official.OfficialService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @since 2021-02-20
 * @author andyssder
 */
//@SpringBootTest
class OfficialBizTest {

    private OfficialService officialService;

    @Autowired
    private void setOfficialRepository(OfficialService officialService) {
        this.officialService = officialService;
    }

    @Test
    void addOfficial() {
    }

    @Test
    void deleteOfficial() {
    }

    @Test
    void updateOfficial() {
    }

    @Test
    void getAllOfficial() {
    }

    @Test
    void getOfficialById() {
    }
}