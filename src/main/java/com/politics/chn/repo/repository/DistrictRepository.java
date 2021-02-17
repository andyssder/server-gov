package com.politics.chn.repo.repository;

import com.politics.chn.model.po.DistrictPO;
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

    public DistrictPO getByID(int id) {
        return districtDao.getOneById(id);
    }

    public List<DistrictPO> getByLevel(int level) {
        return districtDao.getByLevel(level);
    }

    public List<DistrictPO> getChildrenById(int id) {
        DistrictPO districtPO = getByID(id);
        return districtDao.getChildren(districtPO.getLft(), districtPO.getRgt(), districtPO.getLevel());
    }

    public List<DistrictPO> getParentById(int id) {
        DistrictPO districtPO = getByID(id);
        return districtDao.getParent(districtPO.getLft(), districtPO.getRgt());
    }

}
