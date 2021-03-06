package com.politics.chn.repo.repository;

import com.politics.chn.domain.official.value.CarrotDO;
import com.politics.chn.repo.dao.CarrotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-02-18 11:31
 * @author andyssder
 */
@Repository
public class CarrotRepository {

    private CarrotDao carrotDao;

    @Autowired
    private void setCarrotDao(CarrotDao carrotDao) {
        this.carrotDao = carrotDao;
    }

    public List<CarrotDO> getAll() {
        return carrotDao.getAll();
    }

    public List<CarrotDO> getByDistrictLevel(int districtLevel) {
        return carrotDao.getByDistrictLevel(districtLevel);
    }

    public CarrotDO getOneById(long id) {
        return carrotDao.getOneById(id);
    }

    public Boolean insertOne(CarrotDO carrotDO) {
        return carrotDao.insertOne(carrotDO);
    }

    public Boolean updateOne(CarrotDO carrotDO) {
        return carrotDao.updateOne(carrotDO);
    }

    public Boolean deleteOne(long id) {
        return carrotDao.deleteOne(id);
    }
}
