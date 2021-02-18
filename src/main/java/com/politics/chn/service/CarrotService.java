package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.dto.CarrotDTO;
import com.politics.chn.model.po.CarrotPO;
import com.politics.chn.repo.repository.CarrotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-18 11:41
 */
@Service
public class CarrotService {

    private CarrotRepository carrotRepository;

    @Autowired
    private void setPitRepository(CarrotRepository carrotRepository) {
        this.carrotRepository = carrotRepository;
    }

    public Long addCarrot(Map<String, Object> addParams) {
        boolean paramsCheck = addParams.containsKey("name")
                && addParams.containsKey("pitLevel");
        Assert.isTrue(paramsCheck, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        String name = (String) addParams.get("name");
        String shortName = (String) addParams.get("shortName");
        Integer pitLevel = (Integer) addParams.get("pitLevel");
        CarrotPO newCarrot = new CarrotPO(name, shortName, pitLevel);
        Assert.isTrue(carrotRepository.insertOne(newCarrot), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return newCarrot.getId();
    }

    public void updateCarrot(long id, Map<String, Object> updateParams) {
        Assert.isTrue(carrotRepository.updateOne(id, updateParams), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<CarrotDTO> getCarrotList(Integer pitLevel) {
        List<CarrotPO> tempResult = new ArrayList<>();
        if (pitLevel != null) {
            tempResult = carrotRepository.getByPitLevel(pitLevel);
        } else {
            tempResult = carrotRepository.getAll();
        }
        return convertPOList2DTOList(tempResult);
    }

    private List<CarrotDTO> convertPOList2DTOList(List<CarrotPO> carrotPOList) {
        List<CarrotDTO> result = new ArrayList<>();
        carrotPOList.forEach(carrotPO -> {
            result.add(new CarrotDTO(carrotPO.getId(), carrotPO.getName(), carrotPO.getShortName()));
        });
        return result;
    }
}
