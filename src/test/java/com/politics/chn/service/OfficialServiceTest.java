package com.politics.chn.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author andyssder
 * @create 2021-02-20 23:18
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