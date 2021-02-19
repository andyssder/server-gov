package com.politics.chn.controller;

import com.politics.chn.service.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andyssder
 * @create 2021-02-20 14:45
 */
@RestController
@RequestMapping("/party")
@CrossOrigin
public class PartyController {
    private PartyService partyService;

    @Autowired
    private void setPartyService(PartyService partyService) {
        this.partyService = partyService;
    }
}
