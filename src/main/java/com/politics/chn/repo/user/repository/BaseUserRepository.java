package com.politics.chn.repo.user.repository;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.user.dao.BaseUserDao;
import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.repo.user.po.BaseUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class BaseUserRepository {
    private BaseUserDao baseUserDao;

    @Autowired
    public void setBaseUserDao(BaseUserDao baseUserDao) {
        this.baseUserDao = baseUserDao;
    }

    public BaseUserPO getOneByField(String field, String value) {
        return baseUserDao.getOneByField(field, value);
    }

    public boolean addUser(BaseUserPO baseUser) {
        return baseUserDao.insertOne(baseUser);
    }

    public List<BaseUserPO> getAll() {
        return baseUserDao.getAll();
    }

}
