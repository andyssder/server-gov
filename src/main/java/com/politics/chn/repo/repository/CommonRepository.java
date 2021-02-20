package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.value.EthnicityDO;
import com.politics.chn.model.domain.value.PartyDO;
import com.politics.chn.repo.dao.EthnicityDao;
import com.politics.chn.repo.dao.PartyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 16:32
 */
@Repository
public class CommonRepository {
    private EthnicityDao ethnicityDao;

    private PartyDao partyDao;

    @Autowired
    private void setEthnicityDao(EthnicityDao ethnicityDao) {
        this.ethnicityDao = ethnicityDao;
    }

    @Autowired
    private void setPartyDao(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    public List<EthnicityDO> getEthnicityList() {
        return ethnicityDao.getAll();
    }

    public List<PartyDO> getPartyList() {
        return partyDao.getAll();
    }
}
