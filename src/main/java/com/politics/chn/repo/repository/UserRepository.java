package com.politics.chn.repo.repository;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserInfoDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.dao.PermissionDao;
import com.politics.chn.repo.dao.RoleDao;
import com.politics.chn.repo.dao.UserInfoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-03-31 22:30
 */
@Repository
public class UserRepository {

    private UserInfoDao userInfoDao;
    private RoleDao roleDao;
    private PermissionDao permissionDao;

    @Autowired
    public void setUserInfoDao(UserInfoDao userInfoDao) {
        this.userInfoDao = userInfoDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setPermissionDao(PermissionDao permissionMapper) {
        this.permissionDao = permissionDao;
    }

    public UserDO getUserByField(String field, String value) {
        UserInfoDO userInfoDO = userInfoDao.getOneByField(field, value);
        long id = userInfoDO.getId();
        List<RoleDO> roles = roleDao.getRolesByUserId(id);
        List<PermissionDO> permissions = permissionDao.getPermissionsByUserId(id);

        UserDO userDO = new UserDO(userInfoDO, roles, permissions);
        return userDO;
    }
}
