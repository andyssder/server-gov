package com.politics.chn.repo.user.repository;

import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.repo.user.dao.RolePermissionRelationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class RolePermissionRelationRepository {

    private RolePermissionRelationDao rolePermissionRelationDao;

    @Autowired
    public void setRolePermissionRelationDao(RolePermissionRelationDao rolePermissionRelationDao) {
        this.rolePermissionRelationDao = rolePermissionRelationDao;
    }

    public boolean insertRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
        return rolePermissionRelationDao.insertRolePermissionRelation(rolePermissionRelation);
    }

    public boolean deleteRolePermissionRelation(long roleId) {
        return rolePermissionRelationDao.deleteRolePermissionRelation(roleId);
    }

}
