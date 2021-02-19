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
 * @author: andyssder
 * @create: 2021-02-18 12:57
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
    }

    @Test
    void updateCarrot() {
        CarrotDO newCarrot = new CarrotDO();
        newCarrot.setName("test-addCarrot");
        newCarrot.setPitLevel(1);
        Long id = carrotService.addCarrot(newCarrot);
        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("name", "test-after-updateCarrot");
        Assertions.assertThrows(CommonException.class, () -> carrotService.updateCarrot(-1, updateParams), "更新不存在Carrot错误");
        Assertions.assertDoesNotThrow(() -> carrotService.updateCarrot(id, updateParams), "更新Carrot异常");
        CarrotDO carrotDO = carrotDao.getOneById(id);
        Assertions.assertEquals("test-after-updateCarrot", carrotDO.getName(), "更新Carrot名称失败");
        carrotDao.deleteOne(id);
    }

    @Test
    void getCarrotList() {
        // TODO: 目前只测试了一种情况
        Assertions.assertNotNull(carrotService.getCarrotList(null), "获取全部列表错误");
    }
}