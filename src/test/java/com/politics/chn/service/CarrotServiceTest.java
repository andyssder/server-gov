package com.politics.chn.service;

import com.politics.chn.repo.official.dao.CarrotDao;
import com.politics.chn.service.official.CarrotService;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @since 2021-02-18
 * @author andyssder
 */
//@SpringBootTest
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

//    @Test
//    void addCarrot() {
//        Carrot newCarrot = new Carrot();
//        newCarrot.setName("test-addCarrot");
//        newCarrot.setDistrictLevel(1);
//        Long id = carrotService.addCarrot(newCarrot);
//        Assertions.assertNotNull(id, "插入Pit错误");
//        carrotDao.deleteOne(id, true);
//    }
//
//    @Test
//    void updateCarrot() {
//        Carrot newCarrot = new Carrot();
//        newCarrot.setName("test-updateCarrot");
//        newCarrot.setDistrictLevel(1);
//
//        Carrot targetDO = new Carrot();
//        targetDO.setId(-1L);
//        targetDO.setName("test-after-updateCarrot");
//        targetDO.setDistrictLevel(1);
//
//        Long id = carrotService.addCarrot(newCarrot);
//        Assertions.assertThrows(CommonException.class, () -> carrotService.updateCarrot(targetDO), "更新不存在Carrot错误");
//
//        targetDO.setId(id);
//        Assertions.assertDoesNotThrow(() -> carrotService.updateCarrot(targetDO), "更新Carrot异常");
//        Carrot updatedCarrotDO = carrotDao.getOneById(id);
//        Assertions.assertEquals(targetDO.getName(), updatedCarrotDO.getName(), "更新Carrot名称失败");
//        carrotDao.deleteOne(id, true);
//    }
//
//    @Test
//    void getCarrotList() {
//        // TODO: 目前只测试了一种情况
//        Assertions.assertNotNull(carrotService.getCarrotList(null), "获取全部列表错误");
//    }
}