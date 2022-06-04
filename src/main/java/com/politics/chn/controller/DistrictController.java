package com.politics.chn.controller;

import com.politics.chn.application.DistrictBiz;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.application.dto.DistrictDTO;
import com.politics.chn.common.enums.biz.DistrictTypeEnum;
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
    @Autowired
    private DistrictBiz districtBiz;

    @GetMapping(value = "/provinces")
    public List<DistrictDTO> getProvinces() {
        return districtBiz.getProvinces();
    }

    @GetMapping(value = "/cities")
    public List<DistrictDTO> getCities(@RequestParam (value = "id") Integer id) {
        return districtBiz.getCities(id);
    }

    @GetMapping(value = "/type")
    public List<CommonEnumDTO> getDistrictTypes() {
        return districtBiz.getDistrictTypes();
    }
}
