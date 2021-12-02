package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.domain.official.entity.CarrotDO;
import com.politics.chn.domain.official.repository.CarrotRepository;
import com.politics.chn.repo.official.dao.CarrotDao;
import com.politics.chn.repo.official.po.CarrotPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @since 2021-02-18 11:31
 * @author andyssder
 */
@Repository
public class CarrotRepositoryImpl implements CarrotRepository {

    private CarrotDao carrotDao;

    @Autowired
    private void setCarrotDao(CarrotDao carrotDao) {
        this.carrotDao = carrotDao;
    }

    @Override
    public CarrotDO find(Long id) {
        CarrotPO carrotPO = carrotDao.getOneById(id);
        return BeanUtil.toBean(carrotPO, CarrotDO.class);
    }

    @Override
    public List<CarrotDO> query(CarrotQuery query) {
        if (Objects.nonNull(query.getDistrictLevel())) {
            return getByDistrictLevel(query.getDistrictLevel());
        }
        return getAll();
    }

    private List<CarrotDO> getByDistrictLevel(int districtLevel) {
        List<CarrotPO> list = carrotDao.getByDistrictLevel(districtLevel);

        return list.stream().map(item -> BeanUtil.toBean(item, CarrotDO.class)).collect(Collectors.toList());
    }

    private List<CarrotDO> getAll() {
        List<CarrotPO> list = carrotDao.getAll();

        return list.stream().map(item -> BeanUtil.toBean(item, CarrotDO.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        return carrotDao.deleteOne(id);
    }

    @Override
    public boolean save(CarrotDO carrotDO) {
        if (Objects.isNull(carrotDO.getId())) {
            return insertOne(carrotDO);
        } else {
            return updateOne(carrotDO);
        }
    }

    private Boolean insertOne(CarrotDO carrotDO) {
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        if (!carrotDao.insertOne(carrotPO)) {
            return false;
        }
        carrotDO.setId(carrotPO.getId());
        return true;
    }

    private Boolean updateOne(CarrotDO carrotDO) {
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        return carrotDao.updateOne(carrotPO);
    }

}
