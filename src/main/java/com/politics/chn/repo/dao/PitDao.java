package com.politics.chn.repo.dao;

import com.politics.chn.domain.official.value.PitDO;
import com.politics.chn.repo.dao.mapper.PitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-08 17:33
 */
@Repository
public class PitDao {
    private PitMapper pitMapper;

    @Autowired
    private void setPitMapper(PitMapper pitMapper) {
        this.pitMapper = pitMapper;
    }

    public List<PitDO> getAll() {
        return pitMapper.getAll();
    }

    public List<PitDO> getByDistrictLevel(int districtLevel) {
        return pitMapper.getByDistrictLevel(districtLevel);
    }

    public List<PitDO> getChildren(int lft, int rgt, int level) {
        return pitMapper.getLower(lft, rgt, level);
    }

    public PitDO getOneById(long id) {
        return pitMapper.getOneById(id);
    }

    public boolean insertOne(PitDO pit) {
        return pitMapper.insertOne(pit) > 0;
    }

    public boolean updateOne(PitDO pit) {
        return pitMapper.updateOne(pit) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? pitMapper.realDeleteOne(id) > 0 : pitMapper.deleteOne(id) > 0;
    }
}
