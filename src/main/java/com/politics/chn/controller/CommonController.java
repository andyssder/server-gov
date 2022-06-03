package com.politics.chn.controller;

import com.politics.chn.application.CommonBiz;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.domain.official.entity.Ethnicity;
import com.politics.chn.domain.official.entity.Party;
import com.politics.chn.service.official.EthnicityService;
import com.politics.chn.service.official.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@RestController
@RequestMapping
public class CommonController {

    @Autowired
    CommonBiz commonBiz;

    @GetMapping(value = "/ethnicity")
    public List<Ethnicity> getEthnicityList() {
        return commonBiz.getEthnicityList();
    }

    @GetMapping(value = "/party")
    public List<Party> getPartyList() {
        return commonBiz.getPartyList();
    }

    @GetMapping(value = "/ranking")
    public List<CommonEnumDTO> getRankingList() {
        return commonBiz.getRankingList();
    }
}
