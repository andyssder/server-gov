package com.politics.chn.controller;

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
    private CarrotService carrotService;

    @Autowired
    private void setCarrotService(CarrotService carrotService) {
        this.carrotService = carrotService;
    }

    @PostMapping
    public Long addCarrot(@RequestBody Carrot carrot) {
        return carrotService.addCarrot(carrot);
    }

    @PutMapping
    public void updateCarrot(@RequestBody Carrot carrot) {
        carrotService.updateCarrot(carrot);
    }

    @GetMapping
    public List<Carrot> getCarrotList(@RequestParam(value = "pitId", required = false) Long pitId) {
        CarrotQuery carrotQuery = new CarrotQuery();
        carrotQuery.setPitId(pitId);
        return carrotService.queryCarrot(carrotQuery);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarrot(@PathVariable long id) {
        carrotService.deleteCarrot(id);
    }

}
