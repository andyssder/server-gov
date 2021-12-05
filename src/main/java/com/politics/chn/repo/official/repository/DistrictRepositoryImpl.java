package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.query.DistrictQuery;
import com.politics.chn.domain.official.repository.DistrictRepository;
import com.politics.chn.repo.official.dao.DistrictDao;
import com.politics.chn.repo.official.po.DistrictPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-06 16:45
 * @author andyssder
 */
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

    private DistrictDao districtDao;

    @Autowired
    private void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public District find(Long id) {
        DistrictPO districtPO = districtDao.getOneById(id.intValue());
        return BeanUtil.toBean(districtPO, District.class);
    }

    @Override
    public List<District> query(DistrictQuery query) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(District aggregate) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }
}
