package com.politics.chn.service.official;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.DistrictDO;
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

    public List<DistrictDO> getProvinces() {
        DistrictQuery query = new DistrictQuery();
        query.setLevel(1);
        return districtRepository.query(query);
    }

    public List<DistrictDO> getCities(Integer parentId) {

        DistrictQuery query = new DistrictQuery();
        query.setPid(parentId);
        return districtRepository.query(query);
    }

}
