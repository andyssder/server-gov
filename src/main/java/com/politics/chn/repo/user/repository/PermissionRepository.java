package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.po.PermissionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-04-05 11:00
 */
@Repository
public class PermissionRepository {

    private PermissionDao permissionDao;

    @Autowired
    private void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public List<PermissionPO> getPermissionsByRoleId(long roleId) {
        return permissionDao.getPermissionsByRoleId(roleId);
    }

    public List<PermissionPO> getAll() {
        return permissionDao.getAll();
    }

    public boolean insertOne(PermissionPO permission) {
        return permissionDao.insertOne(permission);
    }

    public boolean updateOne(PermissionPO permission) {
        return permissionDao.updateOne(permission);
    }

    public boolean updateMany(List<PermissionPO> permissions) {
        return permissionDao.updateMany(permissions);
    }


    public boolean deleteOne(long id) {
        return permissionDao.deleteOne(id);
    }

}
