package com.politics.chn.controller;

import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.domain.official.entity.CarrotDO;
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
    public Long addCarrot(@RequestBody CarrotDO carrotDO) {
        return carrotService.addCarrot(carrotDO);
    }

    @PutMapping
    public void updateCarrot(@RequestBody CarrotDO carrotDO) {
        carrotService.updateCarrot(carrotDO);
    }

    @GetMapping
    public List<CarrotDO> getCarrotList(@RequestParam(value = "districtLevel", required = false) Integer districtLevel) {
        CarrotQuery carrotQuery = new CarrotQuery();
        carrotQuery.setDistrictLevel(districtLevel);
        return carrotService.queryCarrot(carrotQuery);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarrot(@PathVariable long id) {
        carrotService.deleteCarrot(id);
    }

}
