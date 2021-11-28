package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.PersonMapper;
import com.politics.chn.repo.official.po.PersonPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Repository
public class PersonDao {
    private PersonMapper personMapper;

    @Autowired
    private void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public boolean addOne(PersonPO person) {
        return personMapper.insertOne(person) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? personMapper.realDeleteOne(id) > 0 : personMapper.deleteOne(id) > 0;
    }

    public boolean updateOne(PersonPO person) {
        return personMapper.updateOne(person) > 0;
    }

    public List<PersonPO> getAll() {
        return personMapper.getAll();
    }

    public PersonPO getOneById(Long id) {
        return personMapper.getOneById(id);
    }

}
