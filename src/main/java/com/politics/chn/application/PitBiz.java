package com.politics.chn.application;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.application.dto.PitDTO;
import com.politics.chn.common.enums.biz.PitTypeEnum;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.PitQuery;
import com.politics.chn.service.official.DistrictService;
import com.politics.chn.service.official.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Service
public class PitBiz {

    @Autowired
    private PitService pitService;

    @Autowired
    private DistrictService districtService;

    public Long addPit(Pit pit) {
        return pitService.addPit(pit);
    }

    public void updatePit(Pit pit) {
        pitService.updatePit(pit);
    }

    public void deletePit(long id) {
        pitService.deletePit(id);
    }

    public List<PitDTO> getPitList(PitQuery query) {
        List<Pit> pits = pitService.getPitList(query);
        return pits.stream().map(this::transfer).collect(Collectors.toList());
    }

    public List<CommonEnumDTO> getPitTypeList() {
        return PitTypeEnum.getAll();
    }

    private PitDTO transfer(Pit pit) {
        if (Objects.isNull(pit)) {
            return null;
        }
        PitDTO pitDTO = BeanUtil.toBean(pit, PitDTO.class);
        pitDTO.setTypeName(PitTypeEnum.getDescByType(pitDTO.getType()));
        pitDTO.setRankingName(RankingEnum.getDescByRanking(pitDTO.getRanking()));

        List<District> districts = districtService.getFullPath(pitDTO.getDistrictId());
        pitDTO.setDistrictName(districts.stream().map(District::getName).collect(Collectors.joining()));
        pitDTO.setDistrictPath(districts.stream().map(District::getId).collect(Collectors.toList()));

        pitDTO.setHasChildren(pitService.countChildren(pitDTO.getId()) > 0);
        return pitDTO;
    }
}
