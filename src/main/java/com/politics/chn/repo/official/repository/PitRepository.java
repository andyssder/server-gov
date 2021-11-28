package com.politics.chn.repo.official.repository;

import com.politics.chn.repo.official.dao.PitDao;
import com.politics.chn.repo.official.po.PitPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-08
 * @author andyssder
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

    public List<PitPO> getPitListByLevel(int level) {
        return pitDao.getByLevel(level);
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

    public Boolean updateOne(PitPO pitPO) {
        return pitDao.updateOne(pitPO);
    }

    public Boolean deleteOne(long id) {
        return pitDao.deleteOne(id);
    }
}
