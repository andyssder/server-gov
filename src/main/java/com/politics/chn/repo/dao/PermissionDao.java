package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.repo.dao.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:45
 */
@Repository
public class PermissionDao {

    private PermissionMapper permissionMapper;

    @Autowired
    public void setPermissionDao(PermissionMapper permissionMapper) {
        this.permissionMapper = permissionMapper;
    }

    public List<PermissionDO> getPermissionsByUserId(long userId) {
        return permissionMapper.getListByUserId(userId);
    }

    public List<PermissionDO> getAll() {
        return permissionMapper.getAll();
    }

    public boolean insertOne(PermissionDO permission) {
        return permissionMapper.insertOne(permission) > 0;
    }

    public boolean updateOne(PermissionDO permission) {
        return permissionMapper.updateOne(permission) > 0;
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? permissionMapper.realDeleteOne(id) > 0 : permissionMapper.deleteOne(id) > 0;
    }
}
