package com.politics.chn.repo.dao;

import com.politics.chn.domain.official.value.CarrotDO;
import com.politics.chn.repo.dao.mapper.CarrotMapper;
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

    public List<CarrotDO> getAll() {
        return carrotMapper.getAll();
    }

    public List<CarrotDO> getByDistrictLevel(int districtLevel) {
        return carrotMapper.getByDistrictLevel(districtLevel);
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
