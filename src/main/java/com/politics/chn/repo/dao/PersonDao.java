package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.repo.dao.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-18 17:41
 */
@Repository
public class PersonDao {
    private PersonMapper personMapper;

    @Autowired
    private void setPersonMapper(PersonMapper personMapper) {
        this.personMapper = personMapper;
    }

    public boolean addOne(PersonDO personDO) {
        return personMapper.insertOne(personDO) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? personMapper.realDeleteOne(id) > 0 : personMapper.deleteOne(id) > 0;
    }

    public boolean updateOne(PersonDO personDO) {
        return personMapper.updateOne(personDO) > 0;
    }

    public List<OfficialDO> getAll() {
        return personMapper.getAll();
    }

    public OfficialDO getOneById(Long id) {
        return personMapper.getOneById(id);
    }

}
