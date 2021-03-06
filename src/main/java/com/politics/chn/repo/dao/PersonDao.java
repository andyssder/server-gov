package com.politics.chn.repo.dao;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.po.PersonPO;
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
        PersonPO personPO = personDO2PO(personDO);
        Integer result = personMapper.insertOne(personPO);
        if (result > 0) {
            personDO.setId(personPO.getId());
            return true;
        }
        return false;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? personMapper.realDeleteOne(id) > 0 : personMapper.deleteOne(id) > 0;
    }

    public boolean updateOne(PersonDO personDO) {
        PersonPO personPO = personDO2PO(personDO);
        return personMapper.updateOne(personPO) > 0;
    }

    public List<OfficialDO> getAll() {
        return personMapper.getAll();
    }

    public OfficialDO getOneById(Long id) {
        return personMapper.getOneById(id);
    }

    // TODO: 再考虑如何转换
    private PersonPO personDO2PO(PersonDO personDO) {
        PersonPO personPO = new PersonPO();
        BeanUtil.copyProperties(personDO, personPO, "party", "ethnicity", "ancestralHome", "birthPlace", "workPlace");
        if (personDO.getParty() != null) {
            personPO.setPartyId(personDO.getParty().getId());
        }
        if (personDO.getEthnicity() != null) {
            personPO.setEthnicityId(personDO.getEthnicity().getId());
        }
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
