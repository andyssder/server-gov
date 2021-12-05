package com.politics.chn.repo.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

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
//        List<Permission> permissionList = permissionDao.getPermissionsByUserId(6);
//        System.out.println(permissionList);
//        Assertions.assertEquals(1, permissionList.size());
//    }
}
