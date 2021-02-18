package com.politics.chn.repo.repository;

import com.politics.chn.repo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: andyssder
 * @create: 2021-02-18 17:42
 */
@Repository
public class PersonRepository {
    private PersonDao personDao;

    @Autowired
    private void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }
}
