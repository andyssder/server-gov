package com.politics.chn.repo.repository;

import com.politics.chn.model.domain.value.DistrictDO;
import com.politics.chn.repo.dao.DistrictDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:45
 */
@Repository
public class DistrictRepository {

    private DistrictDao districtDao;

    @Autowired
    private void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    public DistrictDO getById(int id) {
        return districtDao.getOneById(id);
    }

    public List<DistrictDO> getByLevel(int level) {
        return districtDao.getByLevel(level);
    }

    public List<DistrictDO> getChildrenById(int id) {
        DistrictDO districtDO = getById(id);
        return districtDao.getChildren(districtDO.getLft(), districtDO.getRgt(), districtDO.getLevel());
    }

    public List<DistrictDO> getParentById(int id) {
        DistrictDO districtDO = getById(id);
        return districtDao.getParent(districtDO.getLft(), districtDO.getRgt());
    }

}
