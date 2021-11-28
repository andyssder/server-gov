package com.politics.chn.repo.official.repository;

import com.politics.chn.repo.official.dao.PersonDao;
import com.politics.chn.repo.official.po.PersonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class PersonRepository {

    private PersonDao personDao;

    @Autowired
    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public boolean addOne(PersonPO person) {
        return personDao.addOne(person);
    }

    public boolean deleteOne(long id) {
        return personDao.deleteOne(id);
    }

    public boolean updateOne(PersonPO person) {
        return personDao.updateOne(person);
    }

    public List<PersonPO> getAll() {
        return personDao.getAll();
    }

    public PersonPO getOneById(Long id) {
        return personDao.getOneById(id);
    }

}
