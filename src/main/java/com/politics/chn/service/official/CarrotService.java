package com.politics.chn.service.official;

import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.Carrot;
import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.repository.CarrotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

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

    public Long addCarrot(Carrot carrot) {
        Assert.isTrue(carrotRepository.save(carrot), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return carrot.getId();
    }

    public void updateCarrot(Carrot carrot) {
        Assert.isTrue(carrotRepository.save(carrot), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<Carrot> queryCarrot(CarrotQuery carrotQuery) {
        return carrotRepository.query(carrotQuery);
    }

    public void deleteCarrot(long id) {
        Assert.isTrue(carrotRepository.remove(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public String getCarrotShowNameById(Long id) {
        Assert.notNull(id, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
        Carrot carrot = carrotRepository.find(id);
        if (Objects.isNull(carrot)) {
            return "";
        }
        return StringUtils.emptyToDefault(carrot.getShortName(), carrot.getName());
    }
}
