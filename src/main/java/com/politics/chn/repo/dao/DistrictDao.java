package com.politics.chn.repo.dao;

import com.politics.chn.model.po.DistrictPO;
import com.politics.chn.repo.dao.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:45
 */
@Repository
public class DistrictDao {

    private DistrictMapper districtMapper;

    @Autowired
    public void setLocationMapper (DistrictMapper districtMapper) {
        this.districtMapper = districtMapper;
    }

    public List<DistrictPO> getAll() {
        return districtMapper.getAll();
    }

    public DistrictPO getOneById(int id) {
        return districtMapper.getOneById(id);
    }

    public List<DistrictPO> getByLevel(int level) {
        return districtMapper.getByLevel(level);
    }

    public List<DistrictPO> getChildren(int lbb, int ubb, int level) {
        return districtMapper.getLower(lbb, ubb, level);
    }

    public List<DistrictPO> getParent(int lbb, int ubb) {
        return districtMapper.getUpper(lbb, ubb);
    }
}
