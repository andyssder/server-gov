package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.PartyMapper;
import com.politics.chn.repo.official.po.PartyPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/** 14:00
 * @author andyssder
 */
@Repository
public class PartyDao {
    private PartyMapper partyMapper;

    @Autowired
    private void setPartyMapper(PartyMapper partyMapper) {
        this.partyMapper = partyMapper;
    }

    public List<PartyPO> getAll() {
        return partyMapper.getAll();
    }

    public PartyPO getOneById(int id) {
        return partyMapper.getOneById(id);
    }
}
