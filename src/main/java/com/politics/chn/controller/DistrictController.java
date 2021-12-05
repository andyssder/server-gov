package com.politics.chn.controller;

import com.politics.chn.domain.official.entity.District;
import com.politics.chn.service.official.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-02-06
 * @author andyssder
 */
@RestController
@RequestMapping("/districts")
public class DistrictController {
    private DistrictService districtService;

    @Autowired
    private void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping(value = "/provinces")
    public List<District> getProvinces() {
        return districtService.getProvinces();
    }

    @GetMapping(value = "/cities")
    public List<District> getCities(@RequestParam (value = "id") Integer id) {
        return districtService.getCities(id);
    }
}
