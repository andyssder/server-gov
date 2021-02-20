package com.politics.chn.repo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author andyssder
 * @create 2021-02-20 23:15
 */
@SpringBootTest
class ProfileDaoTest {

    private ProfileDao profileDao;

    @Autowired
    private void setProfileDao(ProfileDao profileDao) {
        this.profileDao = profileDao;
    }

    @Test
    void addOne() {
    }

    @Test
    void addMany() {
    }

    @Test
    void deleteOne() {
    }

    @Test
    void testDeleteOne() {
    }

    @Test
    void deleteOneByPersonId() {
    }

    @Test
    void testDeleteOneByPersonId() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void updateMany() {
    }

    @Test
    void getAll() {
    }

    @Test
    void getByPersonId() {
    }
}