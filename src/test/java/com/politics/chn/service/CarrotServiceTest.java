package com.politics.chn.service;

import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.domain.value.CarrotDO;
import com.politics.chn.repo.dao.CarrotDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;


/**
 * @author andyssder
 * @create 2021-02-18 12:57
 */
@SpringBootTest
class CarrotServiceTest {

    private CarrotService carrotService;
    private CarrotDao carrotDao;

    @Autowired
    private void setCarrotService(CarrotService carrotService) {
        this.carrotService = carrotService;
    }

    @Autowired
    private void setCarrotDao(CarrotDao carrotDao) {
        this.carrotDao = carrotDao;
    }

    @Test
    void addCarrot() {
        CarrotDO newCarrot = new CarrotDO();
        newCarrot.setName("test-addCarrot");
        newCarrot.setPitLevel(1);
        Long id = carrotService.addCarrot(newCarrot);
        Assertions.assertNotNull(id, "插入Pit错误");
        carrotDao.deleteOne(id, true);
    }

    @Test
    void updateCarrot() {
        CarrotDO newCarrot = new CarrotDO();
        newCarrot.setName("test-updateCarrot");
        newCarrot.setPitLevel(1);

        CarrotDO targetDO = new CarrotDO();
        targetDO.setId(-1L);
        targetDO.setName("test-after-updateCarrot");
        targetDO.setPitLevel(1);

        Long id = carrotService.addCarrot(newCarrot);
        Assertions.assertThrows(CommonException.class, () -> carrotService.updateCarrot(targetDO), "更新不存在Carrot错误");

        targetDO.setId(id);
        Assertions.assertDoesNotThrow(() -> carrotService.updateCarrot(targetDO), "更新Carrot异常");
        CarrotDO updatedCarrotDO = carrotDao.getOneById(id);
        Assertions.assertEquals(targetDO.getName(), updatedCarrotDO.getName(), "更新Carrot名称失败");
        carrotDao.deleteOne(id, true);
    }

    @Test
    void getCarrotList() {
        // TODO: 目前只测试了一种情况
        Assertions.assertNotNull(carrotService.getCarrotList(null), "获取全部列表错误");
    }
}