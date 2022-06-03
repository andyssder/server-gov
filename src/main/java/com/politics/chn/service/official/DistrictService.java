package com.politics.chn.service.official;

import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.common.enums.biz.DistrictTypeEnum;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.query.DistrictQuery;
import com.politics.chn.domain.official.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @since 2021-02-06
 * @author andyssder
 */
@Service
public class DistrictService {

    private DistrictRepository districtRepository;

    @Autowired
    private void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> getProvinces() {
        DistrictQuery query = new DistrictQuery();
        query.setLevel(1);
        return districtRepository.query(query);
    }

    public List<District> getCities(Integer parentId) {

        DistrictQuery query = new DistrictQuery();
        query.setPid(parentId);
        return districtRepository.query(query);
    }

    public List<District> getFullPath(Integer id) {
        Assert.notNull(id, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        List<District> list = districtRepository.queryFullPath(id);
        return list;
    }

    public List<CommonEnumDTO> getDistrictTypes() {
        return DistrictTypeEnum.getAll();
    }

}
