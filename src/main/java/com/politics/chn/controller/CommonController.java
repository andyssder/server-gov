package com.politics.chn.controller;

import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.domain.official.value.PartyDO;
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
    private PartyService partyService;

    @Autowired
    private EthnicityService ethnicityService;

    @GetMapping(value = "/ethnicity")
    public List<EthnicityDO> getEthnicityList() {
        return ethnicityService.getEthnicityList();
    }

    @GetMapping(value = "/party")
    public List<PartyDO> getPartyList() {
        return partyService.getPartyList();
    }
}
