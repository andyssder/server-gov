package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.EthnicityMapper;
import com.politics.chn.repo.official.po.EthnicityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Repository
public class EthnicityDao {

    private EthnicityMapper ethnicityMapper;

    @Autowired
    private void setEthnicityMapper(EthnicityMapper ethnicityMapper) {
        this.ethnicityMapper = ethnicityMapper;
    }

    public List<EthnicityPO> getAll() {
        return ethnicityMapper.getAll();
    }

    public EthnicityPO getOneById(int id) {
        return ethnicityMapper.getOneById(id);
    }
}
