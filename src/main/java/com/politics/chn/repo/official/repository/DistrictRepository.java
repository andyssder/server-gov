package com.politics.chn.repo.official.repository;

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
public class DistrictRepository {

    private DistrictDao districtDao;

    @Autowired
    private void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    public DistrictPO getById(int id) {
        return districtDao.getOneById(id);
    }

    public List<DistrictPO> getByLevel(int level) {
        return districtDao.getByLevel(level);
    }

    public List<DistrictPO> getChildrenById(int id) {
        DistrictPO districtPO = getById(id);
        return districtDao.getChildren(districtPO.getLft(), districtPO.getRgt(), districtPO.getLevel());
    }

    public List<DistrictPO> getParentById(int id) {
        DistrictPO districtPO = getById(id);
        return districtDao.getParent(districtPO.getLft(), districtPO.getRgt());
    }

}
