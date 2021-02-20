package com.politics.chn.repo.dao;

import com.politics.chn.model.domain.value.DistrictDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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
    public void mainTest() {
        List<DistrictDO> provinces = districtDao.getByLevel(1);
        Assertions.assertEquals(provinces.size(), 34, "读取省份信息出错!");
        for (DistrictDO province : provinces) {
            List<DistrictDO> cities = districtDao.getChildren(province.getLft(), province.getRgt(), province.getLevel());
            cities.forEach(city -> {
                List<DistrictDO> parents = districtDao.getParent(city.getLft(), city.getRgt());
                Assertions.assertEquals(province, parents.get(1), "省市关系错误");

                List<DistrictDO> children = districtDao.getChildren(city.getLft(), city.getRgt(), city.getLevel());
                children.forEach(child -> {
                    List<DistrictDO> countiesParents = districtDao.getParent(child.getLft(), child.getRgt());
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
        Assertions.assertEquals(3215, districtDao.getAll().size(), "获取全部数据错误");
    }
}
