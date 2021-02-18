package com.politics.chn.repo.repository;

import com.politics.chn.model.po.CarrotPO;
import com.politics.chn.repo.dao.CarrotDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-18 11:31
 */
@Repository
public class CarrotRepository {

    private CarrotDao carrotDao;

    @Autowired
    private void setPitDao(CarrotDao carrotDao) {
        this.carrotDao = carrotDao;
    }

    public List<CarrotPO> getAll() {
        return carrotDao.getAll();
    }

    public List<CarrotPO> getByPitLevel(int pitLevel) {
        return carrotDao.getByPitLevel(pitLevel);
    }

    public CarrotPO getOneById(long id) {
        return carrotDao.getOneById(id);
    }

    public Boolean insertOne(CarrotPO CarrotPO) {
        return carrotDao.insertOne(CarrotPO);
    }

    public Boolean updateOne(long id, Map<String, Object> updateParams) {
        return carrotDao.updateOne(id, updateParams);
    }

}
