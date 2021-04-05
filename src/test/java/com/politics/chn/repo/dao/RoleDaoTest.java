package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.RoleDO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RoleDaoTest {
    private RoleDao roleDao;

    @Autowired
    private void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Test
    void getRolesByUserId() {
        List<RoleDO> roleList = roleDao.getRolesByUserId(6);
        System.out.println(roleList);
        Assertions.assertEquals(1, roleList.size());
    }
}