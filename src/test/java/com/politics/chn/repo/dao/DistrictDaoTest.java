package com.politics.chn.repo.dao;

import com.politics.chn.domain.official.value.DistrictDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author andyssder
 * @create 2021-02-06 16:46
 */
@SpringBootTest
class DistrictDaoTest {

    private DistrictDao districtDao;

    @Autowired
    private void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Test
    void getAll() {
        Assertions.assertEquals(3215, districtDao.getAll().size(), "获取全部数据错误");
    }

    @Test
    void getOneById() {
        List<DistrictDO> districtList = districtDao.getAll();
        districtList.forEach(district -> {
            DistrictDO target = districtDao.getOneById(district.getId());
            int lft = target.getLft();
            int rgt = target.getRgt();
            int level = target.getLevel();
            List<DistrictDO> children = target.getChildren();
            List<DistrictDO> parents = target.getParents();
            children.forEach(child -> {
                Assertions.assertEquals(level + 1, child.getLevel(), "child数据获取错误");
                Assertions.assertTrue(child.getLft() > lft, "child数据获取错误");
                Assertions.assertTrue(child.getRgt() < rgt, "child数据获取错误");
            });
            parents.forEach(parent -> {
                Assertions.assertTrue(level - 1 == parent.getLevel() || level - 2 == parent.getLevel(), "parent数据获取错误");
                Assertions.assertTrue(parent.getLft() < lft, "parent数据获取错误");
                Assertions.assertTrue(parent.getRgt() > rgt, "parent数据获取错误");
            });
        });
    }

    @Test
    void getByLevel() {
        List<DistrictDO> districtList = districtDao.getAll();
        AtomicInteger provinceCount = new AtomicInteger();
        AtomicInteger cityCount = new AtomicInteger();
        AtomicInteger countyCount = new AtomicInteger();
        districtList.forEach(district -> {
            if (district.getLevel() == 1) {
                provinceCount.getAndIncrement();
            } else if (district.getLevel() == 2) {
                cityCount.getAndIncrement();
            } else {
                countyCount.getAndIncrement();
            }
        });
        Assertions.assertEquals(provinceCount.get(), districtDao.getByLevel(1).size(), "获取所有省份数据错误");
        Assertions.assertEquals(cityCount.get(), districtDao.getByLevel(2).size(), "获取所有市数据错误");
        Assertions.assertEquals(countyCount.get(), districtDao.getByLevel(3).size(), "获取所有县数据错误");
    }

    @Test
    void getChildren() {
        List<DistrictDO> provinceList = districtDao.getByLevel(1);
        provinceList.forEach(province -> {
            int provinceLft = province.getLft();
            int provinceRgt = province.getRgt();
            int provinceLevel = province.getLevel();
            List<DistrictDO> cityList = districtDao.getChildren(provinceLft, provinceRgt, provinceLevel);
            cityList.forEach(city -> {
                int cityLft = city.getLft();
                int cityRgt = city.getRgt();
                int cityLevel = city.getLevel();
                Assertions.assertEquals(provinceLevel + 1, cityLevel, "获取市数据失败");
                Assertions.assertTrue(cityLft > provinceLft, "获取市数据失败");
                Assertions.assertTrue(cityRgt < provinceRgt, "获取市数据失败");
                List<DistrictDO> countyList = districtDao.getChildren(cityLft, cityRgt, cityLevel);
                countyList.forEach(county -> {
                    Assertions.assertEquals(cityLevel + 1, county.getLevel(), "获取县数据失败");
                    Assertions.assertTrue(county.getLft() > cityLft, "获取县数据失败");
                    Assertions.assertTrue(county.getRgt() < cityRgt, "获取县数据失败");
                });
            });
        });
    }

    @Test
    void getParent() {
        List<DistrictDO> countyList = districtDao.getByLevel(3);
        countyList.forEach(county -> {
            int countyLft = county.getLft();
            int countyRgt = county.getRgt();
            int countyLevel = county.getLevel();
            List<DistrictDO> cityList = districtDao.getParent(countyLft, countyRgt);
            cityList.forEach(city -> {
                Assertions.assertTrue(countyLevel - 1 == city.getLevel() || countyLevel - 2 == city.getLevel(), "县获取市数据失败");
                Assertions.assertTrue(city.getLft() < countyLft, "县获取市数据失败");
                Assertions.assertTrue(city.getRgt() > countyRgt, "县获取市数据失败");
            });
        });
        List<DistrictDO> cityList = districtDao.getByLevel(2);
        cityList.forEach(city -> {
            int cityLft = city.getLft();
            int cityRgt = city.getRgt();
            int cityLevel = city.getLevel();
            List<DistrictDO> provinceList = districtDao.getParent(cityLft, cityRgt);
            provinceList.forEach(province -> {
                Assertions.assertEquals(cityLevel - 1, province.getLevel(), "市获取省数据失败");
                Assertions.assertTrue(province.getLft() < cityLft, "市获取省数据失败");
                Assertions.assertTrue(province.getRgt() > cityRgt, "市获取省数据失败");
            });

        });
    }
}
