package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.value.CarrotDO;
import com.politics.chn.repo.official.dao.CarrotDao;
import com.politics.chn.repo.official.po.CarrotPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
        List<CarrotPO> list = carrotDao.getAll();

        return list.stream().map(item -> BeanUtil.toBean(item, CarrotDO.class)).collect(Collectors.toList());
    }

    public List<CarrotDO> getByDistrictLevel(int districtLevel) {
        List<CarrotPO> list = carrotDao.getByDistrictLevel(districtLevel);

        return list.stream().map(item -> BeanUtil.toBean(item, CarrotDO.class)).collect(Collectors.toList());
    }

    public CarrotDO getOneById(long id) {
        CarrotPO carrotPO = carrotDao.getOneById(id);
        return BeanUtil.toBean(carrotPO, CarrotDO.class);
    }

    public Boolean insertOne(CarrotDO carrotDO) {
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        if (!carrotDao.insertOne(carrotPO)) {
            return false;
        }
        carrotDO.setId(carrotPO.getId());
        return true;
    }

    public Boolean updateOne(CarrotDO carrotDO) {
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        return carrotDao.updateOne(carrotPO);
    }

    public Boolean deleteOne(long id) {
        return carrotDao.deleteOne(id);
    }
}
