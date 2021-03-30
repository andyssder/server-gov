package com.politics.chn.repo.dao;

import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.repo.dao.mapper.EthnicityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 14:00
 */
@Repository
public class EthnicityDao {

    private EthnicityMapper ethnicityMapper;

    @Autowired
    private void setEthnicityMapper(EthnicityMapper ethnicityMapper) {
        this.ethnicityMapper = ethnicityMapper;
    }

    public List<EthnicityDO> getAll() {
        return ethnicityMapper.getAll();
    }

    public EthnicityDO getOneById(int id) {
        return ethnicityMapper.getOneById(id);
    }
}
