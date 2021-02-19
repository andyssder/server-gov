package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.po.PersonPO;
import com.politics.chn.repo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public Boolean addPerson(PersonPO personPO) {
        return personDao.addOne(personPO);
    }

    public Boolean updatePerson(long id, Map<String, Object> updateParams) {
        return personDao.updateOne(id, updateParams);
    }

    public List<PersonDO> getAllPerson() {
        return personDao.getAll();
    }

    public Boolean deletePerson(long id) {
        return personDao.deleteOne(id);
    }
}
