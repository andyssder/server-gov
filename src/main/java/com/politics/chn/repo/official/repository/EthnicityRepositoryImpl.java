package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.Ethnicity;
import com.politics.chn.domain.official.query.EthnicityQuery;
import com.politics.chn.domain.official.repository.EthnicityRepository;
import com.politics.chn.repo.official.dao.EthnicityDao;
import com.politics.chn.repo.official.po.EthnicityPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2021-11-28
 */
@Repository
public class EthnicityRepositoryImpl implements EthnicityRepository {
    private EthnicityDao ethnicityDao;

    @Autowired
    private void setEthnicityDao(EthnicityDao ethnicityDao) {
        this.ethnicityDao = ethnicityDao;
    }

    @Override
    public Ethnicity find(Long id) {
        EthnicityPO ethnicityPO = ethnicityDao.getOneById(id.intValue());
        return BeanUtil.toBean(ethnicityPO, Ethnicity.class);
    }

    @Override
    public List<Ethnicity> query(EthnicityQuery query) {
        List<EthnicityPO> list = ethnicityDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, Ethnicity.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(Ethnicity aggregate) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }
}
