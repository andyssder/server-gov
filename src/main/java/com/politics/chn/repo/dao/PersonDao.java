package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.po.PersonPO;
import com.politics.chn.repo.dao.mapper.PersonMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public boolean addOne(PersonPO personPO) {
        return personMapper.insertOne(personPO) > 0;
    }

    public boolean updateOne(long id, Map<String, Object> updateParams) {
        return personMapper.updateOne(id, updateParams) > 0;
    }

    public List<PersonDO> getAll() {
        return personMapper.getAll();
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? personMapper.realDeleteOne(id) > 0 : personMapper.deleteOne(id) > 0;
    }
}
