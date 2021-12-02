package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.PitDO;
import com.politics.chn.repo.official.dao.PitDao;
import com.politics.chn.repo.official.po.PitPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<PitDO> getAll() {
        List<PitPO> list = pitDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, PitDO.class)).collect(Collectors.toList());
    }

    public List<PitDO> getByDistrictLevel(int districtLevel) {
        List<PitPO> list = pitDao.getByDistrictLevel(districtLevel);
        return list.stream().map(item -> BeanUtil.toBean(item, PitDO.class)).collect(Collectors.toList());
    }

    public List<PitDO> getPitListByLevel(int level) {
        List<PitPO> list =  pitDao.getByLevel(level);
        return list.stream().map(item -> BeanUtil.toBean(item, PitDO.class)).collect(Collectors.toList());
    }

    public List<PitDO> getChildren(long id) {
        PitPO pitPO = getPitPOById(id);
        List<PitPO> list =  pitDao.getChildren(pitPO.getLft(), pitPO.getRgt(), pitPO.getLevel());
        return list.stream().map(item -> BeanUtil.toBean(item, PitDO.class)).collect(Collectors.toList());
    }

    public PitDO getOneById(long id) {
        PitPO pitPO = pitDao.getOneById(id);
        return BeanUtil.toBean(pitPO, PitDO.class);
    }

    public Boolean insertOne(PitDO pitDO) {
        PitPO pitPO = BeanUtil.toBean(pitDO, PitPO.class);
        if (!pitDao.insertOne(pitPO)) {
            return false;
        }
        pitDO.setId(pitPO.getId());
        return pitDao.insertOne(pitPO);
    }

    public Boolean updateOne(PitDO pitDO) {
        PitPO pitPO = BeanUtil.toBean(pitDO, PitPO.class);
        return pitDao.updateOne(pitPO);
    }

    public Boolean deleteOne(long id) {
        return pitDao.deleteOne(id);
    }

    private PitPO getPitPOById(long id) {
        return pitDao.getOneById(id);
    }
}
