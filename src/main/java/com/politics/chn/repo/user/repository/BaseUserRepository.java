package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.user.dao.BaseUserDao;
import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.repo.user.dao.UserRoleRelationDao;
import com.politics.chn.repo.user.po.BaseUserPO;
import com.politics.chn.repo.user.po.UserRoleRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class BaseUserRepository {
    private BaseUserDao baseUserDao;

    private UserRoleRelationDao userRoleRelationDao;

    @Autowired
    public void setBaseUserDao(BaseUserDao baseUserDao) {
        this.baseUserDao = baseUserDao;
    }

    @Autowired
    public void setUserRoleRelationDao(UserRoleRelationDao userRoleRelationDao) {
        this.userRoleRelationDao = userRoleRelationDao;
    }

    public BaseUserDO getOneByField(String field, String value) {
        BaseUserPO baseUserPO = baseUserDao.getOneByField(field, value);
        return BeanUtil.toBean(baseUserPO, BaseUserDO.class);
    }

    public boolean addUser(BaseUserDO baseUserDO) {
        BaseUserPO baseUserPO = BeanUtil.toBean(baseUserDO, BaseUserPO.class);
        return baseUserDao.insertOne(baseUserPO);
    }

    public List<BaseUserDO> getAll() {
        List<BaseUserPO> list = baseUserDao.getAll();
        return list.stream().map(baseUserPO -> BeanUtil.toBean(baseUserPO, BaseUserDO.class)).collect(Collectors.toList());
    }

    public boolean deleteUserRoleRelation(long userId) {
        return userRoleRelationDao.deleteUserRoleRelation(userId);
    }


    public boolean insertUserRoleRelation(long userId, long roleId) {
        UserRoleRelationPO userRoleRelationPO = new UserRoleRelationPO(userId, roleId);
        return userRoleRelationDao.insertUserRoleRelation(userRoleRelationPO);
    }
}
