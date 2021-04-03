package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.dao.mapper.RoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-01 20:30
 */
@Repository
public class RoleDao {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<RoleDO> getRolesByUserId(Long userId) {
        return roleMapper.getListByUserId(userId);
    }
}
