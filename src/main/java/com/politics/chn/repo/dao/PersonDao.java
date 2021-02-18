package com.politics.chn.repo.dao;

import com.politics.chn.repo.dao.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: andyssder
 * @create: 2021-02-18 17:41
 */
@Repository
public class PersonDao {
    private PersonMapper personMapper;

    @Autowired
    private void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }
}
