package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.value.EthnicityDO;
import com.politics.chn.repo.dao.EthnicityDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 14:09
 */
@Repository
public class EthnicityRepository {
    private EthnicityDao ethnicityDao;

    @Autowired
    private void setEthnicityDao(EthnicityDao ethnicityDao) {
        this.ethnicityDao = ethnicityDao;
    }

    public List<EthnicityDO> getAll() {
        return ethnicityDao.getAll();
    }

    public EthnicityDO getOneById(int id) {
        return ethnicityDao.getOneById(id);
    }
}
