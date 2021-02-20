package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.CarrotDO;
import com.politics.chn.repo.dao.mapper.CarrotMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-18 11:19
 */
@Repository
public class CarrotDao {
    private CarrotMapper carrotMapper;

    @Autowired
    private void setCarrotMapper(CarrotMapper carrotMapper) {
        this.carrotMapper = carrotMapper;
    }

    public List<CarrotDO> getAll() {
        return carrotMapper.getAll();
    }

    public List<CarrotDO> getByPitLevel(int pitLevel) {
        return carrotMapper.getByPitLevel(pitLevel);
    }

    public CarrotDO getOneById(long id) {
        return carrotMapper.getOneById(id);
    }

    public boolean insertOne(CarrotDO carrotDO) {
        return carrotMapper.insertOne(carrotDO) > 0;
    }

    public boolean updateOne(CarrotDO carrotDO) {
        return carrotMapper.updateOne(carrotDO) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? carrotMapper.realDeleteOne(id) > 0 : carrotMapper.deleteOne(id) > 0;
    }
}
