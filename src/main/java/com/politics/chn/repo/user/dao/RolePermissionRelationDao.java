package com.politics.chn.repo.user.dao;

import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.repo.user.dao.mapper.RolePermissionRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class RolePermissionRelationDao {

    private RolePermissionRelationMapper rolePermissionRelationMapper;

    @Autowired
    public void setRolePermissionRelationMapper(RolePermissionRelationMapper rolePermissionRelationMapper) {
        this.rolePermissionRelationMapper = rolePermissionRelationMapper;
    }

    public boolean insertRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
        return rolePermissionRelationMapper.insertOneRolePermissionRelation(rolePermissionRelation) > 0;
    }

    public boolean deleteRolePermissionRelation(long roleId) {
        return rolePermissionRelationMapper.deleteRolePermissionRelationByRoleId(roleId) >= 0;
    }
}
