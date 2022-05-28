package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import com.politics.chn.repo.user.dao.mapper.RolePermissionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author andyssder
 * @since 2021-11-28
 */
@Repository
public class RolePermissionRelationDao {

    private RolePermissionRelationMapper rolePermissionRelationMapper;

    @Autowired
    public void setRolePermissionRelationMapper(RolePermissionRelationMapper rolePermissionRelationMapper) {
        this.rolePermissionRelationMapper = rolePermissionRelationMapper;
    }

    public boolean insertRolePermissionRelation(RolePermissionRelationPO rolePermissionRelationPO) {
        return rolePermissionRelationMapper.insertOneRolePermissionRelation(rolePermissionRelationPO) > 0;
    }

    public boolean deleteRolePermissionRelation(long roleId) {
        return rolePermissionRelationMapper.deleteRolePermissionRelationByRoleId(roleId) >= 0;
    }
}
