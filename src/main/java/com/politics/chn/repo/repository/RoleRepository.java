package com.politics.chn.repo.repository;

import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.repo.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 11:00
 */
@Repository
public class RoleRepository {

    private RoleDao roleDao;

    @Autowired
    private void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<RoleDO> getAll() {
        return roleDao.getAll();
    }

    public List<RoleDO> getRolesByUserId(long userId) {
        return roleDao.getRolesByUserId(userId);
    }

    public boolean insertOne(RoleDO role) {
        return roleDao.insertOne(role);
    }

    public boolean updateOne(RoleDO role) {
        return roleDao.updateOne(role);
    }

    public boolean updateMany(List<RoleDO> roles) {
        return roleDao.updateMany(roles);
    }

    public boolean deleteOne(long id) {
        return roleDao.deleteOne(id);
    }

    public boolean insertRolePermissionRelation(RolePermissionRelation rolePermissionRelation) {
        return roleDao.insertRolePermissionRelation(rolePermissionRelation);
    }

    public boolean deleteRolePermissionRelation(long roleId) {
        return roleDao.deleteRolePermissionRelation(roleId);
    }


}
