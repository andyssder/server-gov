package com.politics.chn.controller;

import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.domain.official.value.PartyDO;
import com.politics.chn.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 16:31
 */
@RestController
@RequestMapping
public class CommonController {
    private CommonService commonService;

    @Autowired
    private void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping(value = "/ethnicity")
    public List<EthnicityDO> getEthnicityList() {
        return commonService.getEthnicityList();
    }

    @GetMapping(value = "/party")
    public List<PartyDO> getPartyList() {
        return commonService.getPartyList();
    }
}
