package com.politics.chn.repo.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.PitDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

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

    public Long insertOne(PitDO pitDO) {
        PitPO pitPO = new PitPO();
        BeanUtil.copyProperties(pitDO, pitPO);
        pitDao.insertOne(pitPO);
        return pitPO.getId();
    }

    public Boolean updateOne(PitDO pitDO) {
        PitPO pitPO = new PitPO();
        BeanUtil.copyProperties(pitDO, pitPO);
        return pitDao.updateOne(pitPO);
    }

    public Boolean deleteOne(long id) {
        return pitDao.deleteOne(id);
    }
}
