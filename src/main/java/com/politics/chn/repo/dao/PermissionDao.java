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

    public List<PermissionDO> getPermissionsByUserId(Long userId) {
        return permissionMapper.getListByUserId(userId);
    }
}
