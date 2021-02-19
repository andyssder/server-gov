package com.politics.chn.controller;

import com.politics.chn.service.EthnicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyssder
 * @create 2021-02-20 14:46
 */
@RestController
@RequestMapping("/ethnicity")
@CrossOrigin
public class EthnicityController {
    private EthnicityService ethnicityService;

    @Autowired
    private void setEthnicityService(EthnicityService ethnicityService) {
        this.ethnicityService = ethnicityService;
    }
}
