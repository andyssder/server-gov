package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.DistrictDO;
import com.politics.chn.repo.dao.mapper.DistrictMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-06 16:45
 */
@Repository
public class DistrictDao {

    private DistrictMapper districtMapper;

    @Autowired
    private void setDistrictMapper(DistrictMapper districtMapper) {
        this.districtMapper = districtMapper;
    }

    public List<DistrictDO> getAll() {
        return districtMapper.getAll();
    }

    public DistrictDO getOneById(int id) {
        return districtMapper.getOneById(id);
    }

    public List<DistrictDO> getByLevel(int level) {
        return districtMapper.getByLevel(level);
    }

    public List<DistrictDO> getChildren(int lft, int rgt, int level) {
        return districtMapper.getLower(lft, rgt, level);
    }

    public List<DistrictDO> getParent(int lft, int rgt) {
        return districtMapper.getUpper(lft, rgt);
    }
}
