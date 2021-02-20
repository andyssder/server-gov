package com.politics.chn.service;

import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.domain.value.PitDO;
import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.PitDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-17 09:55
 */
@SpringBootTest
class PitServiceTest {

    private PitService pitService;
    private PitDao pitDao;

    @Autowired
    private void setPitService(PitService pitService) {
        this.pitService = pitService;
    }

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    @Test
    void addPit() {
        PitPO newPit1 = new PitPO();
        newPit1.setPid(1L);
        newPit1.setName("test-add");
        newPit1.setDistrictLevel(1);
        newPit1.setRank(1);
        Long id1 = pitService.addPit(newPit1);
        Assertions.assertNotNull(id1, "插入Pit错误");
        PitPO newPit2 = new PitPO();
        newPit2.setPid(id1);
        newPit2.setName("test-add2");
        newPit2.setDistrictLevel(2);
        newPit2.setRank(2);
        Long id2 = pitService.addPit(newPit2);
        Assertions.assertNotNull(id2, "插入子Pit错误");

        pitDao.deleteOne(id1, true);
        pitDao.deleteOne(id2, true);
        // TODO： 增加其他参数的校验
    }

    @Test
    void updatePit() {
        PitPO newPit = new PitPO();
        newPit.setPid(1L);
        newPit.setName("test-update");
        newPit.setDistrictLevel(1);
        newPit.setRank(1);
        Long id = pitService.addPit(newPit);
        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("name", "test-after-update");
        Assertions.assertThrows(CommonException.class, () -> pitService.updatePit(-1, updateParams), "更新不存在Pit错误");
        Assertions.assertDoesNotThrow(() -> pitService.updatePit(id, updateParams), "更新Pit异常");
        PitDO pitDO = pitDao.getOneById(id);
        Assertions.assertEquals("test-after-update", pitDO.getName(), "更新Pit名称失败");
        pitDao.deleteOne(id, true);
    }

    @Test
    void deletePit() {
        PitPO newPit = new PitPO();
        newPit.setPid(1L);
        newPit.setName("test-delete");
        newPit.setDistrictLevel(1);
        newPit.setRank(1);
        Long id = pitService.addPit(newPit);
        Assertions.assertThrows(CommonException.class, () -> pitService.deletePit(-1), "删除不存在Pit错误");
        Assertions.assertDoesNotThrow(() -> pitService.deletePit(id), "删除Pit异常");
        PitDO pitDO = pitDao.getOneById(id);
        Assertions.assertTrue(pitDO.getDeleted(), "删除Pit失败");
        pitDao.deleteOne(id, true);
    }

    @Test
    void getPitList() {
        // TODO: 目前只测试了一种情况
        Assertions.assertThrows(CommonException.class, () -> pitService.getPitList(1L, 1), "参数校验错误");
        Assertions.assertNotEquals(0, pitService.getPitList(null, null).size(), "获取全部列表错误");
    }
}