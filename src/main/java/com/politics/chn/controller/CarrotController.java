package com.politics.chn.controller;

import com.politics.chn.domain.official.value.CarrotDO;
import com.politics.chn.service.CarrotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-18 12:08
 */
@RestController
@RequestMapping("/carrots")
@CrossOrigin
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
        return carrotService.getCarrotList(districtLevel);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCarrot(@PathVariable long id) {
        carrotService.deleteCarrot(id);
    }

}
