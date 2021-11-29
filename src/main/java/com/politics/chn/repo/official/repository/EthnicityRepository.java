package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.repo.official.dao.EthnicityDao;
import com.politics.chn.repo.official.po.EthnicityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<EthnicityDO> getEthnicityList() {
        List<EthnicityPO> list = ethnicityDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, EthnicityDO.class)).collect(Collectors.toList());
    }

    public EthnicityDO getOneById(int id) {
        EthnicityPO ethnicityPO = ethnicityDao.getOneById(id);
        return BeanUtil.toBean(ethnicityPO, EthnicityDO.class);
    }
}
