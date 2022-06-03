package com.politics.chn.controller;

import com.politics.chn.application.PitBiz;
import com.politics.chn.application.dto.CommonEnumDTO;
import com.politics.chn.application.dto.PitDTO;
import com.politics.chn.common.enums.biz.PitTypeEnum;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.PitQuery;
import com.politics.chn.service.official.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-02-16
 * @author andyssder
 */
@RestController
@RequestMapping("/pits")
public class PitController {

    @Autowired
    private PitBiz pitBiz;
    @PostMapping
    public Long addPit(@RequestBody Pit pit) {
        return pitBiz.addPit(pit);
    }

    @PutMapping
    public void updatePit(@RequestBody Pit pit) {
        pitBiz.updatePit(pit);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePit(@PathVariable long id) {
        pitBiz.deletePit(id);
    }

    @GetMapping
    public List<PitDTO> getPitList(@ModelAttribute PitQuery query) {
        return pitBiz.getPitList(query);
    }

    @GetMapping(value = "/type")
    public List<CommonEnumDTO> getPitTypeList() {
        return pitBiz.getPitTypeList();
    }
}
