package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.dto.DistrictDTO;
import com.politics.chn.model.po.DistrictPO;
import com.politics.chn.repo.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:45
 */
@Service
public class DistrictService {

    private DistrictRepository districtRepository;

    @Autowired
    public void setLocationMapper (DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<DistrictDTO> getProvinces() {
        return convertPOList2DTOList(districtRepository.getByLevel(1));
    }

    public List<DistrictDTO> getCities(Integer parentId) {
        Assert.notNull(parentId, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        return convertPOList2DTOList(districtRepository.getChildrenById(parentId));
    }

    private List<DistrictDTO> convertPOList2DTOList(List<DistrictPO> districtPOList) {
        List<DistrictDTO> result = new ArrayList<>();
        districtPOList.forEach(locationPO -> {
            result.add(new DistrictDTO(locationPO.getId(), locationPO.getName()));
        });
        return result;
    }
}
