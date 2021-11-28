package com.politics.chn.repo.official.repository;

import com.politics.chn.repo.official.dao.CarrotDao;
import com.politics.chn.repo.official.po.CarrotPO;
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

    public List<CarrotPO> getAll() {
        return carrotDao.getAll();
    }

    public List<CarrotPO> getByDistrictLevel(int districtLevel) {
        return carrotDao.getByDistrictLevel(districtLevel);
    }

    public CarrotPO getOneById(long id) {
        return carrotDao.getOneById(id);
    }

    public Boolean insertOne(CarrotPO carrot) {
        return carrotDao.insertOne(carrot);
    }

    public Boolean updateOne(CarrotPO carrot) {
        return carrotDao.updateOne(carrot);
    }

    public Boolean deleteOne(long id) {
        return carrotDao.deleteOne(id);
    }
}
