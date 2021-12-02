package com.politics.chn.service.official;

import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.CarrotDO;
import com.politics.chn.domain.official.repository.CarrotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Service
public class CarrotService {

    private CarrotRepository carrotRepository;

    @Autowired
    private void setCarrotRepository(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    public Long addCarrot(CarrotDO carrotDO) {
        Assert.isTrue(carrotRepository.save(carrotDO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return carrotDO.getId();
    }

    public void updateCarrot(CarrotDO carrotDO) {
        Assert.isTrue(carrotRepository.save(carrotDO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<CarrotDO> queryCarrot(CarrotQuery carrotQuery) {
        return carrotRepository.query(carrotQuery);
    }

    public void deleteCarrot(long id) {
        Assert.isTrue(carrotRepository.remove(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }
}
