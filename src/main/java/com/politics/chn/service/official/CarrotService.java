package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.value.CarrotDO;
import com.politics.chn.repo.official.po.CarrotPO;
import com.politics.chn.repo.official.repository.CarrotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

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
        Assert.isTrue(carrotDO.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        Assert.isTrue(carrotRepository.insertOne(carrotPO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return carrotPO.getId();
    }

    public void updateCarrot(CarrotDO carrotDO) {
        CarrotPO carrotPO = BeanUtil.toBean(carrotDO, CarrotPO.class);
        Assert.isTrue(carrotRepository.updateOne(carrotPO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<CarrotDO> getCarrotList(Integer districtLevel) {
        List<CarrotPO> list;
        if (districtLevel != null) {
            list = carrotRepository.getByDistrictLevel(districtLevel);
        } else {
            list = carrotRepository.getAll();
        }
        List<CarrotDO> result = list.stream().map(item -> BeanUtil.toBean(item, CarrotDO.class)).collect(Collectors.toList());
        return result;
    }

    public void deleteCarrot(long id) {
        Assert.isTrue(carrotRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }
}
