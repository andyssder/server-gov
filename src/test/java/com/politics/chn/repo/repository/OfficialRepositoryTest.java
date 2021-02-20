package com.politics.chn.repo.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author andyssder
 * @create 2021-02-20 23:15
 */
@SpringBootTest
class OfficialRepositoryTest {

    private OfficialRepository officialRepository;

    @Autowired
    private void setOfficialRepository(OfficialRepository officialRepository) {
        this.officialRepository = officialRepository;
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