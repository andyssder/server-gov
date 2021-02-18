package com.politics.chn.controller;

import com.politics.chn.model.dto.PitDTO;
import com.politics.chn.service.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-16 16:02
 */
@RestController
@RequestMapping("/pits")
@CrossOrigin
public class PitController {

    private PitService pitService;

    @Autowired
    private void setPitService(PitService pitService) {
        this.pitService = pitService;
    }

    @PostMapping
    public Long addPit(@RequestBody Map<String, Object> addParams) {
        return pitService.addPit(addParams);
    }

    @PutMapping(value = "/{id}")
    public void updatePit(@PathVariable long id, @RequestBody Map<String, Object> updateParams) {
        pitService.updatePit(id, updateParams);
    }

    @DeleteMapping(value = "/{id}")
    public void deletePit(@PathVariable long id) {
        pitService.deletePit(id);
    }

    @GetMapping
    public List<PitDTO> getPitList(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "districtLevel", required = false) Integer districtLevel) {
        return pitService.getPitList(id, districtLevel);
    }

}
