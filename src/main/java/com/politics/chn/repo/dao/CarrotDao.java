package com.politics.chn.repo.dao;

import com.politics.chn.model.po.CarrotPO;
import com.politics.chn.repo.dao.mapper.CarrotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-18 11:19
 */
@Repository
public class CarrotDao {
    private CarrotMapper carrotMapper;

    @Autowired
    private void setPitDao(CarrotMapper carrotMapper) {
        this.carrotMapper = carrotMapper;
    }

    public List<CarrotPO> getAll() {
        return carrotMapper.getAll();
    }

    public List<CarrotPO> getByPitLevel(int pitLevel) {
        return carrotMapper.getByPitLevel(pitLevel);
    }

    public CarrotPO getOneById(long id) {
        return carrotMapper.getOneById(id);
    }

    public boolean insertOne(CarrotPO carrotPO) {
        return carrotMapper.insertOne(carrotPO) > 0;
    }

    public boolean updateOne(long id, Map<String, Object> updateParams) {
        return carrotMapper.updateOne(id, updateParams) > 0;
    }

    public boolean deleteOne(long id) {
        return carrotMapper.deleteOne(id) > 0;
    }
}
