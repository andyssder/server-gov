package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.value.DistrictDO;
import com.politics.chn.repo.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-06 16:45
 */
@Service
public class DistrictService {

    private DistrictRepository districtRepository;

    @Autowired
    private void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<DistrictDO> getProvinces() {
        return districtRepository.getByLevel(1);
    }

    public List<DistrictDO> getCities(Integer parentId) {
        List<DistrictDO> result = districtRepository.getChildrenById(parentId);
        Assert.notNull(result, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
        return result;
    }
}
