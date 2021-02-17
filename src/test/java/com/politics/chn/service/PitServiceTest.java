package com.politics.chn.service;

import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.dao.PitDao;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-17 09:55
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
        Map<String, Object> addParams = new HashMap<>();
        addParams.put("pid", 1L);
        addParams.put("name", "test-add");
        addParams.put("districtLevel", 1);
        addParams.put("rank", 1);
        Long id1 = pitService.addPit(addParams);
        Assertions.assertNotNull(id1, "插入Pit错误");
        addParams.put("pid", id1);
        addParams.put("name", "test-add2");
        addParams.put("districtLevel", 2);
        addParams.put("rank", 2);
        Long id2 = pitService.addPit(addParams);
        Assertions.assertNotNull(id2, "插入子Pit错误");

        pitDao.deleteOne(id1, true);
        pitDao.deleteOne(id2, true);
        // TODO： 增加其他参数的校验
    }

    @Test
    void updatePit() {
        Map<String, Object> addParams = new HashMap<>();
        addParams.put("pid", 1L);
        addParams.put("name", "test-update");
        addParams.put("districtLevel", 1);
        addParams.put("rank", 1);
        Long id = pitService.addPit(addParams);
        Map<String, Object> updateParams = new HashMap<>();
        updateParams.put("name", "test-after-update");
        Assertions.assertThrows(CommonException.class, () -> pitService.updatePit(-1, updateParams), "更新不存在Pit错误");
        Assertions.assertDoesNotThrow(() -> pitService.updatePit(id, updateParams), "更新Pit异常");
        PitPO pitPO = pitDao.getOneById(id);
        Assertions.assertEquals("test-after-update", pitPO.getName(), "更新Pit名称失败");
        pitDao.deleteOne(id, true);
    }

    @Test
    void deletePit() {
        Map<String, Object> addParams = new HashMap<>();
        addParams.put("pid", 1L);
        addParams.put("name", "test-delete");
        addParams.put("districtLevel", 1);
        addParams.put("rank", 1);
        Long id = pitService.addPit(addParams);
        Assertions.assertThrows(CommonException.class, () -> pitService.deletePit(-1), "删除不存在Pit错误");
        Assertions.assertDoesNotThrow(() -> pitService.deletePit(id), "删除Pit异常");
        PitPO pitPO = pitDao.getOneById(id);
        Assertions.assertTrue(pitPO.isDeleted(), "删除Pit失败");
        pitDao.deleteOne(id, true);
    }

    @Test
    void getPitList() {
        // TODO: 目前只测试了一种情况
        Assertions.assertThrows(CommonException.class, () -> pitService.getPitList(1L, 1), "参数校验错误");
        Assertions.assertNotEquals(0, pitService.getPitList(null, null).size(), "获取全部列表错误");
    }
}