package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.dao.mapper.PermissionMapper;
import com.politics.chn.repo.user.po.PermissionPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-04-03
 * @author andyssder
 */
@Repository
public class PermissionDao {

    private PermissionMapper permissionMapper;

    @Autowired
    public void setPermissionDao(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public List<PermissionPO> getPermissionsByUserId(long userId) {
        return permissionMapper.getListByUserId(userId);
    }

    public List<PermissionPO> getPermissionsByRoleId(long roleId) {
        return permissionMapper.getListByRoleId(roleId);
    }

    public List<PermissionPO> getPermissionsByRoleIds(List<Long> roleIds) {
        return permissionMapper.getListByRoleIds(roleIds);
    }

    public List<PermissionPO> getAll() {
        return permissionMapper.getAll();
    }

    public boolean insertOne(PermissionPO permission) {
        return permissionMapper.insertOne(permission) > 0;
    }

    public boolean updateOne(PermissionPO permission) {
        return permissionMapper.updateOne(permission) > 0;
    }

    public boolean updateMany(List<PermissionPO> permissions) {
        return permissionMapper.updateMany(permissions) == permissions.size();
    }

    public boolean deleteOne(long id) {
        return permissionMapper.deleteOne(id) > 0;
    }

}
