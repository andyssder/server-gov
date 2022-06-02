package com.politics.chn.repo.official.dao;

import com.politics.chn.repo.official.dao.mapper.CarrotMapper;
import com.politics.chn.repo.official.po.CarrotPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Repository
public class CarrotDao {
    private CarrotMapper carrotMapper;

    @Autowired
    private void setCarrotMapper(CarrotMapper carrotMapper) {
        this.carrotMapper = carrotMapper;
    }

    public List<CarrotPO> getAll() {
        return carrotMapper.getAll();
    }

    public List<CarrotPO> getByPitId(long pitId) {
        return carrotMapper.getByPitId(pitId);
    }

    public CarrotPO getOneById(long id) {
        return carrotMapper.getOneById(id);
    }

    public boolean insertOne(CarrotPO carrot) {
        return carrotMapper.insertOne(carrot) > 0;
    }

    public boolean updateOne(CarrotPO carrot) {
        return carrotMapper.updateOne(carrot) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? carrotMapper.realDeleteOne(id) > 0 : carrotMapper.deleteOne(id) > 0;
    }
}
