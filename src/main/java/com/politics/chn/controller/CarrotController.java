package com.politics.chn.controller;

import com.politics.chn.model.domain.value.CarrotDO;
import com.politics.chn.service.CarrotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

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
    public List<CarrotDO> getCarrotList(@RequestParam(value = "pitLevel", required = false) Integer pitLevel) {
        return carrotService.getCarrotList(pitLevel);
    }

}
