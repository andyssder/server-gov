package com.politics.chn.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.application.dto.CarrotDTO;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.application.dto.DistrictDTO;
import com.politics.chn.common.enums.biz.DistrictTypeEnum;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.Carrot;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.DistrictQuery;
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

        districtDTO.setRankingDesc(RankingEnum.getDescByRanking(districtDTO.getRanking()));
        districtDTO.setTypeDesc(DistrictTypeEnum.getDescByType(districtDTO.getType()));
        return districtDTO;
    }
}
