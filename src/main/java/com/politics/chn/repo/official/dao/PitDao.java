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

    public List<PitPO> getByDistrictId(int districtId) {
        return pitMapper.getByDistrictId(districtId);
    }

    public List<PitPO> getChildren(long pid) {
        return pitMapper.getChildren(pid);
    }
    public List<PitPO> getChildrenByDistrictId(long pid, int districtId) {
        return pitMapper.getChildrenByDistrictId(pid, districtId);
    }

    public Long countChildren(long pid) {
        return pitMapper.countChildren(pid);
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

}
