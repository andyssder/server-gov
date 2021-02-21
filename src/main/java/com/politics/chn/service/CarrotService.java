package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.domain.value.CarrotDO;
import com.politics.chn.repo.repository.CarrotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-18 11:41
 */
@Service
public class CarrotService {

    private CarrotRepository carrotRepository;

    @Autowired
    private void setCarrotRepository(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    public Long addCarrot(CarrotDO carrotDO) {
        Assert.isTrue(carrotDO.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(carrotRepository.insertOne(carrotDO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return carrotDO.getId();
    }

    public void updateCarrot(CarrotDO carrotDO) {
        Assert.isTrue(carrotRepository.updateOne(carrotDO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<CarrotDO> getCarrotList(Integer pitLevel) {
        if (pitLevel != null) {
            return carrotRepository.getByPitLevel(pitLevel);
        } else {
            return carrotRepository.getAll();
        }
    }
}
