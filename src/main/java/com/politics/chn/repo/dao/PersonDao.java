package com.politics.chn.repo.dao;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.PersonDO;
import com.politics.chn.repo.dao.mapper.PersonMapper;
import com.politics.chn.repo.po.PersonPO;
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

    public boolean addOne(PersonDO personDO) {
        PersonPO personPO = transfer(personDO);
        return personMapper.insertOne(personPO) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? personMapper.realDeleteOne(id) > 0 : personMapper.deleteOne(id) > 0;
    }

    public boolean updateOne(PersonDO personDO) {
        PersonPO personPO = transfer(personDO);
        return personMapper.updateOne(personPO) > 0;
    }

    public List<PersonDO> getAll() {
        return personMapper.getAll();
    }

    public PersonDO getOneById(Long id) {
        return personMapper.getOneById(id);
    }

    private PersonPO transfer(PersonDO personDO) {
        PersonPO personPO = BeanUtil.copyProperties(personDO, PersonPO.class,
                "ancestralHome", "birthPlace", "workPlace");
        if (personDO.getAncestralHome() != null) {
            personPO.setAncestralHome(personDO.getAncestralHome().getId());
        }
        if (personDO.getBirthPlace() != null) {
            personPO.setBirthPlace(personDO.getBirthPlace().getId());
        }
        if (personDO.getWorkPlace() != null) {
            personPO.setWorkPlace(personDO.getWorkPlace().getId());
        }
        return personPO;
    }
}
