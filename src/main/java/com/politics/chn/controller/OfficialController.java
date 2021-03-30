package com.politics.chn.controller;

import com.politics.chn.domain.official.OfficialDO;
import com.politics.chn.service.OfficialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-18 17:53
 */
@RestController
@RequestMapping("/officials")
@CrossOrigin
public class OfficialController {
    private OfficialService officialService;

    @Autowired
    private void setOfficialService(OfficialService officialService) {
        this.officialService = officialService;
    }

    @PostMapping
    public void addOfficial(@RequestBody OfficialDO official) {
        officialService.addOfficial(official);
    }

    @PutMapping
    public void updateOfficial(@RequestBody OfficialDO official) {
        officialService.updateOfficial(official);
    }

    @GetMapping
    public List<OfficialDO> getAllOfficials() {
        return officialService.getOfficialList();
    }

    @GetMapping(value = "/{id}")
    public OfficialDO getOfficial(@PathVariable long id) {
        return officialService.getOneOfficial(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOfficial(@PathVariable long id) {
        officialService.deleteOfficial(id);
    }

}
