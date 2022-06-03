package com.politics.chn.application;

import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.domain.official.entity.Ethnicity;
import com.politics.chn.domain.official.entity.Party;
import com.politics.chn.domain.official.query.EthnicityQuery;
import com.politics.chn.domain.official.query.PartyQuery;
import com.politics.chn.service.official.EthnicityService;
import com.politics.chn.service.official.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Service
public class CommonBiz {
    @Autowired
    private PartyService partyService;

    @Autowired
    private EthnicityService ethnicityService;

    public List<Party> getPartyList() {
        return partyService.getPartyList();
    }

    public List<Ethnicity> getEthnicityList() {
        return ethnicityService.getEthnicityList();
    }

    public List<CommonEnumDTO> getRankingList() {
        return RankingEnum.getAll();
    }
}
