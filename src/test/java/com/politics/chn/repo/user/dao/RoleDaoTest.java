package com.politics.chn.repo.user.dao;

import org.springframework.beans.factory.annotation.Autowired;

//@SpringBootTest
class RoleDaoTest {
    private RoleDao roleDao;

    @Autowired
    private void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

//    @Test
//    void getRolesByUserId() {
//        List<Role> roleList = roleDao.getRolesByUserId(6);
//        System.out.println(roleList);
//        Assertions.assertEquals(1, roleList.size());
//    }
}