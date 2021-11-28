package com.politics.chn.repo.user.dao;

import com.politics.chn.domain.user.Entity.PermissionDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//@SpringBootTest
class PermissionDaoTest {
    private PermissionDao permissionDao;

    @Autowired
    private void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }
//
//    @Test
//    void getPermissionsByUserId() {
//        List<PermissionDO> permissionList = permissionDao.getPermissionsByUserId(6);
//        System.out.println(permissionList);
//        Assertions.assertEquals(1, permissionList.size());
//    }
}
