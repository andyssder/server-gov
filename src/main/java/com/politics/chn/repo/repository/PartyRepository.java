package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.value.PartyDO;
import com.politics.chn.repo.dao.PartyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 14:09
 */
@Repository
public class PartyRepository {
    private PartyDao partyDao;

    @Autowired
    private void setPartyDao(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    public List<PartyDO> getAll() {
        return partyDao.getAll();
    }

    public PartyDO getOneById(int id) {
        return partyDao.getOneById(id);
    }
}
