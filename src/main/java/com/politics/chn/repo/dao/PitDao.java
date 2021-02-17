package com.politics.chn.repo.dao;

import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-08 17:33
 */
@Repository
public class PitDao {
    private PitMapper pitMapper;

    @Autowired
    private void setPitDao(PitMapper pitMapper) {
        this.pitMapper = pitMapper;
    }

    public List<PitPO> getAll() {
        return pitMapper.getAll();
    }

    public List<PitPO> getByDistrictLevel(int districtLevel) {
        return pitMapper.getByDistrictLevel(districtLevel);
    }

    public List<PitPO> getChildren(int lft, int rgt, int level) {
        return pitMapper.getLower(lft, rgt, level);
    }

    public PitPO getOneById(long id) {
        return pitMapper.getOneById(id);
    }

    public boolean insertOne(PitPO pitPO) {
        return pitMapper.insertOne(pitPO) > 0;
    }

    public boolean updateOne(long id, Map<String, Object> updateParams) {
        return pitMapper.updateOne(id, updateParams) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? pitMapper.realDeleteOne(id) > 0 : pitMapper.deleteOne(id) > 0;
    }
}
