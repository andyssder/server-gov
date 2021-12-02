package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.DistrictDO;
import com.politics.chn.domain.official.query.DistrictQuery;
import com.politics.chn.domain.official.repository.DistrictRepository;
import com.politics.chn.repo.official.dao.DistrictDao;
import com.politics.chn.repo.official.po.DistrictPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public DistrictDO getById(int id) {
        DistrictPO districtPO = districtDao.getOneById(id);
        return BeanUtil.toBean(districtPO, DistrictDO.class);
    }

    private DistrictPO getDistrictPOById(int id) {
        return districtDao.getOneById(id);
    }

    public List<DistrictDO> getByLevel(int level) {
        List<DistrictPO> list = districtDao.getByLevel(level);
        return list.stream().map(item -> BeanUtil.toBean(item, DistrictDO.class)).collect(Collectors.toList());
    }

    public List<DistrictDO> getChildrenById(int id) {
        DistrictPO districtPO = getDistrictPOById(id);
        List<DistrictPO> list = districtDao.getChildren(districtPO.getLft(), districtPO.getRgt(), districtPO.getLevel());
        return list.stream().map(item -> BeanUtil.toBean(item, DistrictDO.class)).collect(Collectors.toList());
    }

    public List<DistrictDO> getParentById(int id) {
        DistrictPO districtPO = getDistrictPOById(id);
        List<DistrictPO> list = districtDao.getParent(districtPO.getLft(), districtPO.getRgt());
        return list.stream().map(item -> BeanUtil.toBean(item, DistrictDO.class)).collect(Collectors.toList());
    }

    @Override
    public DistrictDO find(Long id) {
        DistrictPO districtPO = districtDao.getOneById(id.intValue());
        return BeanUtil.toBean(districtPO, DistrictDO.class);
    }

    @Override
    public List<DistrictDO> query(DistrictQuery query) {
        return null;
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(DistrictDO aggregate) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }
}
