package com.politics.chn.application;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.application.dto.DistrictDTO;
import com.politics.chn.common.enums.biz.DistrictTypeEnum;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.service.official.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-04
 */
@Service
public class DistrictBiz {

    @Autowired
    private DistrictService districtService;

    public List<DistrictDTO> getProvinces() {

        List<District> districts = districtService.getProvinces();
        return districts.stream().map(this::transfer).collect(Collectors.toList());
    }

    public List<DistrictDTO> getCities(Integer parentId) {

        List<District> districts = districtService.getCities(parentId);

        return districts.stream().map(this::transfer).collect(Collectors.toList());
    }

    public List<CommonEnumDTO> getDistrictTypes() {
        return DistrictTypeEnum.getAll();
    }

    private DistrictDTO transfer(District district) {
        if (Objects.isNull(district)) {
            return null;
        }
        DistrictDTO districtDTO = BeanUtil.toBean(district, DistrictDTO.class);
        districtDTO.setHasChildren(district.getRgt() - district.getLft() > 1);

        districtDTO.setRankingName(RankingEnum.getDescByRanking(districtDTO.getRanking()));
        districtDTO.setTypeName(DistrictTypeEnum.getDescByType(districtDTO.getType()));
        return districtDTO;
    }
}
