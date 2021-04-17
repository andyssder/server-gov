package com.politics.chn.repo.repository;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.dao.PermissionDao;
import com.politics.chn.repo.dao.RoleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 11:00
 */
@Repository
public class PermissionRepository {

    private PermissionDao permissionDao;

    @Autowired
    private void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public List<PermissionDO> getAll() {
        return permissionDao.getAll();
    }

    public boolean insertOne(PermissionDO permission) {
        return permissionDao.insertOne(permission);
    }

    public boolean updateOne(PermissionDO permission) {
        return permissionDao.updateOne(permission);
    }

    public boolean updateMany(List<PermissionDO> permissions) {
        return permissionDao.updateMany(permissions);
    }


    public boolean deleteOne(long id) {
        return permissionDao.deleteOne(id);
    }
}
