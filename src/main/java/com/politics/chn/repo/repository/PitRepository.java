package com.politics.chn.repo.repository;

import com.politics.chn.domain.official.value.PitDO;
import com.politics.chn.repo.dao.PitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-08 17:33
 */
@Repository
public class PitRepository {

    private PitDao pitDao;

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    public List<PitDO> getAll() {
        return pitDao.getAll();
    }

    public List<PitDO> getByDistrictLevel(int districtLevel) {
        return pitDao.getByDistrictLevel(districtLevel);
    }

    public List<PitDO> getChildren(long id) {
        PitDO pitDO = getOneById(id);
        return pitDao.getChildren(pitDO.getLft(), pitDO.getRgt(), pitDO.getLevel());
    }

    public PitDO getOneById(long id) {
        return pitDao.getOneById(id);
    }

    public Boolean insertOne(PitDO pitDO) {
        return pitDao.insertOne(pitDO);
    }

    public Boolean updateOne(PitDO pitDO) {
        return pitDao.updateOne(pitDO);
    }

    public Boolean deleteOne(long id) {
        return pitDao.deleteOne(id);
    }
}
