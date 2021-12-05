package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.Carrot;
import com.politics.chn.domain.official.query.CarrotQuery;
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
    public Carrot find(Long id) {
        CarrotPO carrotPO = carrotDao.getOneById(id);
        return BeanUtil.toBean(carrotPO, Carrot.class);
    }

    @Override
    public List<Carrot> query(CarrotQuery query) {
        if (Objects.nonNull(query.getDistrictLevel())) {
            return getByDistrictLevel(query.getDistrictLevel());
        }
        return getAll();
    }

    private List<Carrot> getByDistrictLevel(int districtLevel) {
        List<CarrotPO> list = carrotDao.getByDistrictLevel(districtLevel);

        return list.stream().map(item -> BeanUtil.toBean(item, Carrot.class)).collect(Collectors.toList());
    }

    private List<Carrot> getAll() {
        List<CarrotPO> list = carrotDao.getAll();

        return list.stream().map(item -> BeanUtil.toBean(item, Carrot.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        return carrotDao.deleteOne(id);
    }

    @Override
    public boolean save(Carrot carrot) {
        if (Objects.isNull(carrot.getId())) {
            return insertOne(carrot);
        } else {
            return updateOne(carrot);
        }
    }

    private Boolean insertOne(Carrot carrot) {
        CarrotPO carrotPO = BeanUtil.toBean(carrot, CarrotPO.class);
        if (!carrotDao.insertOne(carrotPO)) {
            return false;
        }
        carrot.setId(carrotPO.getId());
        return true;
    }

    private Boolean updateOne(Carrot carrot) {
        CarrotPO carrotPO = BeanUtil.toBean(carrot, CarrotPO.class);
        return carrotDao.updateOne(carrotPO);
    }

}
