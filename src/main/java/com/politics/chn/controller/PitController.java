package com.politics.chn.controller;

import com.politics.chn.domain.official.value.PitDO;
import com.politics.chn.service.PitService;
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

    private PitService pitService;

    @Autowired
    private void setPitService(PitService pitService) {
        this.pitService = pitService;
    }

    @PostMapping
    public Long addPit(@RequestBody PitDO pit) {
        return pitService.addPit(pit);
    }

    @PutMapping
    public void updatePit(@RequestBody PitDO pit) {
        pitService.updatePit(pit);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePit(@PathVariable long id) {
        pitService.deletePit(id);
    }

    @GetMapping
    public List<PitDO> getPitList(@RequestParam(value = "type", required = false) String type,
                                  @RequestParam(value = "value", required = false) Long value) {
        return pitService.getPitList(type, value);
    }

}
