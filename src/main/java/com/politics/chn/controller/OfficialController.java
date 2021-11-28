package com.politics.chn.controller;

import com.politics.chn.domain.official.OfficialDO;
import com.politics.chn.application.OfficialBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@RestController
@RequestMapping("/officials")
public class OfficialController {
    private OfficialBiz officialBiz;

    @Autowired
    private void setOfficialService(OfficialBiz officialBiz) {
        this.officialBiz = officialBiz;
    }

    @PostMapping
    public void addOfficial(@RequestBody OfficialDO official) {
        officialBiz.addOfficial(official);
    }

    @PutMapping
    public void updateOfficial(@RequestBody OfficialDO official) {
        officialBiz.updateOfficial(official);
    }

    @GetMapping
    public List<OfficialDO> getAllOfficials() {
        return officialBiz.getOfficialList();
    }

    @GetMapping(value = "/{id}")
    public OfficialDO getOfficial(@PathVariable long id) {
        return officialBiz.getOneOfficial(id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteOfficial(@PathVariable long id) {
        officialBiz.deleteOfficial(id);
    }

}
