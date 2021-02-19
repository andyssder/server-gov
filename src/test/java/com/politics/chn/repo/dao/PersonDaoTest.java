package com.politics.chn.repo.dao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author andyssder
 * @create 2021-02-19 17:22
 */
@SpringBootTest
class PersonDaoTest {

    private PersonDao personDao;

    @Autowired
    private void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    @Test
    void addOne() {
    }

    @Test
    void updateOne() {
    }

    @Test
    void getAll() {
        System.out.println(personDao.getAll());
    }

    @Test
    void deleteOne() {
    }

    @Test
    void testDeleteOne() {
    }
}