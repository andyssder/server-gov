package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.value.DistrictDO;
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
public class DistrictRepository {

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

}
