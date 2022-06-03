package com.politics.chn.controller;

import com.politics.chn.application.CarrotBiz;
import com.politics.chn.application.dto.CarrotDTO;
import com.politics.chn.domain.official.entity.Carrot;
import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.service.official.CarrotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@RestController
@RequestMapping("/carrots")
public class CarrotController {

    @Autowired
    private CarrotBiz carrotBiz;

    @PostMapping
    public Long addCarrot(@RequestBody Carrot carrot) {
        return carrotBiz.addCarrot(carrot);
    }

    @PutMapping
    public void updateCarrot(@RequestBody Carrot carrot) {
        carrotBiz.updateCarrot(carrot);
    }

    @GetMapping
    public List<CarrotDTO> getCarrotList(@ModelAttribute CarrotQuery carrotQuery) {
        return carrotBiz.queryCarrot(carrotQuery);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarrot(@PathVariable long id) {
        carrotBiz.deleteCarrot(id);
    }

}
