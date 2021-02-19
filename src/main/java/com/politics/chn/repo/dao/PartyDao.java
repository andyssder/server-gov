package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.PartyDO;
import com.politics.chn.repo.dao.mapper.PartyMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 14:00
 */
@Repository
public class PartyDao {
    private PartyMapper partyMapper;

    @Autowired
    private void setPartyMapper(PartyMapper partyMapper) {
        this.partyMapper = partyMapper;
    }

    public List<PartyDO> getAll() {
        return partyMapper.getAll();
    }

    public PartyDO getOneById(int id) {
        return partyMapper.getOneById(id);
    }
}
