package com.politics.chn.controller;

import com.politics.chn.model.domain.value.DistrictDO;
import com.politics.chn.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-06 16:50
 */
@RestController
@RequestMapping("/districts")
@CrossOrigin
public class DistrictController {
    private DistrictService districtService;

    @Autowired
    private void setDistrictService(DistrictService districtService) {
        this.districtService = districtService;
    }

    @GetMapping(value = "/provinces")
    public List<DistrictDO> getProvinces() {
        return districtService.getProvinces();
    }

    @GetMapping(value = "/cities")
    public List<DistrictDO> getCities(@RequestParam (value = "id") Integer id) {
        return districtService.getCities(id);
    }
}
