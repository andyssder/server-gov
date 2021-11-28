package com.politics.chn.repo.official.repository;

import com.politics.chn.repo.official.dao.EthnicityDao;
import com.politics.chn.repo.official.po.EthnicityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class EthnicityRepository {
    private EthnicityDao ethnicityDao;

    @Autowired
    private void setEthnicityDao(EthnicityDao ethnicityDao) {
        this.ethnicityDao = ethnicityDao;
    }

    public List<EthnicityPO> getEthnicityList() {
        return ethnicityDao.getAll();
    }

    public EthnicityPO getOneById(int id) {
        return ethnicityDao.getOneById(id);
    }
}
