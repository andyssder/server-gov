package com.politics.chn.controller;

import com.politics.chn.model.domain.value.EthnicityDO;
import com.politics.chn.model.domain.value.PartyDO;
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
@CrossOrigin
public class CommonController {
    private CommonService commonService;

    @Autowired
    private void setCommonService(CommonService commonService) {
        this.commonService = commonService;
    }

    @GetMapping(value = "/party")
    public List<EthnicityDO> getEthnicityList() {
        return commonService.getEthnicityList();
    }

    @GetMapping(value = "/ethnicity")
    public List<PartyDO> getPartyList() {
        return commonService.getPartyList();
    }
}
