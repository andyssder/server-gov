package com.politics.chn.repo.dao;

import com.politics.chn.model.po.DistrictPO;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:46
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DistrictDaoTest {

    private DistrictDao districtDao;

    @Autowired
    public void setLocationDao (DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Test
    public void mainTest() {
        List<DistrictPO> provinces = districtDao.getByLevel(1);
        Assertions.assertEquals(provinces.size(), 34, "读取省份信息出错!");
        for (DistrictPO province : provinces) {
            List<DistrictPO> cities = districtDao.getChildren(province.getLbb(), province.getUbb(), province.getLevel());
            cities.forEach(city -> {
                List<DistrictPO> parents = districtDao.getParent(city.getLbb(), city.getUbb());
                Assertions.assertEquals(province, parents.get(1), "省市关系错误");

                List<DistrictPO> children = districtDao.getChildren(city.getLbb(), city.getUbb(), city.getLevel());
                children.forEach(child -> {
                    List<DistrictPO> countiesParents = districtDao.getParent(child.getLbb(), child.getUbb());
                    Assertions.assertEquals(province, countiesParents.get(1), "省县关系错误");
                    Assertions.assertEquals(city, countiesParents.get(2), "市县关系错误");
                });

            });
        }

    }

    @Test
    public void getByIDTest() {
        Assertions.assertNotNull(districtDao.getOneById(1), "根据id查询错误");
    }

    @Test
    public void getAllTest() {
        Assertions.assertEquals(0, districtDao.getAll().size(), "获取全部数据错误");
    }
}
