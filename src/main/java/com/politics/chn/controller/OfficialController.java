package com.politics.chn.controller;

import com.politics.chn.model.domain.aggregate.OfficialDO;
import com.politics.chn.service.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-18 17:53
 */
@RestController
@RequestMapping("/official")
@CrossOrigin
public class OfficialController {
    private OfficialService officialService;

    @Autowired
    private void setOfficialService(OfficialService officialService) {
        this.officialService = officialService;
    }

    @PostMapping
    public void addPerson(@RequestBody OfficialDO officialDO) {

    }

    @PutMapping(value = "/{id}")
    public void updatePerson(@PathVariable long id, @RequestBody Map<String, Object> updateParams) {

    }

    @GetMapping
    public List<OfficialDO> getAllPerson() {
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public void deletePerson(@PathVariable long id) {

    }

}
