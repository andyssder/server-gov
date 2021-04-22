package com.politics.chn.repo.repository;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.dao.PermissionDao;
import com.politics.chn.repo.dao.RoleDao;
import com.politics.chn.repo.dao.BaseUserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-03-31 22:30
 */
@Repository
public class UserRepository {

    private BaseUserDao baseUserDao;
    private RoleDao roleDao;
    private PermissionDao permissionDao;

    @Autowired
    public void setBaseUserDao(BaseUserDao baseUserDao) {
        this.baseUserDao = baseUserDao;
    }

    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public UserDO getUserByField(String field, String value) {
        BaseUserDO baseUserDO = baseUserDao.getOneByField(field, value);
        if (baseUserDO == null) {
            return null;
        }

        long id = baseUserDO.getId();
        List<RoleDO> roles = roleDao.getRolesByUserId(id);
        List<PermissionDO> permissions = permissionDao.getPermissionsByUserId(id);

        UserDO userDO = new UserDO(baseUserDO, roles, permissions);
        return userDO;
    }

    public boolean addUser(BaseUserDO baseUser) {
        return baseUserDao.insertOne(baseUser);
    }

    public List<BaseUserDO> getAll() {
        return baseUserDao.getAll();
    }


    public boolean insertUserRoleRelation(UserRoleRelation userRoleRelation) {
        return baseUserDao.insertUserRoleRelation(userRoleRelation);
    }

    public boolean deleteUserRoleRelation(long userId) {
        return baseUserDao.deleteUserRoleRelation(userId);
    }

    public List<RoleDO> getRoleListByUserId(long userId) {
        return roleDao.getRolesByUserId(userId);
    }
}
