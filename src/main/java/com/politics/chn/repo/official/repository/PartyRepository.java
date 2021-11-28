package com.politics.chn.repo.official.repository;

import com.politics.chn.repo.official.dao.PartyDao;
import com.politics.chn.repo.official.po.PartyPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class PartyRepository {
    private PartyDao partyDao;

    @Autowired
    private void setPartyDao(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    public List<PartyPO> getPartyList() {
        return partyDao.getAll();
    }
}
