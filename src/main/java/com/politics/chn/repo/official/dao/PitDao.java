package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.PitMapper;
import com.politics.chn.repo.official.po.PitPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-08
 * @author andyssder
 */
@Repository
public class PitDao {
    private PitMapper pitMapper;

    @Autowired
    private void setPitMapper(PitMapper pitMapper) {
        this.pitMapper = pitMapper;
    }

    public List<PitPO> getAll() {
        return pitMapper.getAll();
    }

    public List<PitPO> getByDistrictLevel(int districtLevel) {
        return pitMapper.getByDistrictLevel(districtLevel);
    }

    public List<PitPO> getByLevel(int level) {
        return pitMapper.getByLevel(level);
    }

    public List<PitPO> getChildren(int lft, int rgt, int level) {
        return pitMapper.getLower(lft, rgt, level);
    }

    public PitPO getOneById(long id) {
        return pitMapper.getOneById(id);
    }

    public boolean insertOne(PitPO pit) {
        return pitMapper.insertOne(pit) > 0;
    }

    public boolean updateOne(PitPO pit) {
        return pitMapper.updateOne(pit) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? pitMapper.realDeleteOne(id) > 0 : pitMapper.deleteOne(id) > 0;
    }

    public List<PitPO> getParent(int lft, int rgt) {
        return pitMapper.getUpper(lft, rgt);
    }
}
