package com.politics.chn.controller;

import com.politics.chn.model.dto.DistrictDTO;
import com.politics.chn.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-06 16:50
 */
@RestController
@RequestMapping("/district")
@CrossOrigin
public class DistrictController {
    private DistrictService districtService;

    @Autowired
    private void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping(value = "/provinces")
    public List<DistrictDTO> getProvinces() {
        return districtService.getProvinces();
    }
}
