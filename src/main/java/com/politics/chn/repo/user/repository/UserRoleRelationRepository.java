package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.user.po.UserRoleRelationPO;
import com.politics.chn.repo.user.dao.UserRoleRelationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @since 2021-11-28
 */

@Repository
public class UserRoleRelationRepository {

    private UserRoleRelationDao userRoleRelationDao;

    @Autowired
    public void setUserRoleRelationDao(UserRoleRelationDao userRoleRelationDao) {
        this.userRoleRelationDao = userRoleRelationDao;
    }

    public boolean deleteUserRoleRelation(long userId) {
        return userRoleRelationDao.deleteUserRoleRelation(userId);
    }


    public boolean insertUserRoleRelation(UserRoleRelationPO userRoleRelationPO) {
        return userRoleRelationDao.insertUserRoleRelation(userRoleRelationPO);
    }
}
