package com.politics.chn.repo.repository;

import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.PitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:33
 */
@Repository
public class PitRepository {

    private PitDao pitDao;

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    public List<PitPO> getAll() {
        return pitDao.getAll();
    }

    public List<PitPO> getByDistrictLevel(int districtLevel) {
        return pitDao.getByDistrictLevel(districtLevel);
    }

    public List<PitPO> getChildren(long id) {
        PitPO pitPO = getOneById(id);
        return pitDao.getChildren(pitPO.getLft(), pitPO.getRgt(), pitPO.getLevel());
    }

    public PitPO getOneById(long id) {
        return pitDao.getOneById(id);
    }

    public Boolean insertOne(PitPO pitPO) {
        return pitDao.insertOne(pitPO);
    }

    public Boolean updateOne(long id, Map<String, Object> updateParams) {
        return pitDao.updateOne(id, updateParams);
    }

    public Boolean deleteOne(long id) {
        return pitDao.deleteOne(id);
    }
}
