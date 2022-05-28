package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.po.UserRoleRelationPO;
import com.politics.chn.repo.user.dao.mapper.UserRoleRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author andyssder
 * @since 2021-11-28
 */
@Repository
public class UserRoleRelationDao {

    private UserRoleRelationMapper userRoleRelationMapper;

    @Autowired
    public void setUserRoleRelationMapper(UserRoleRelationMapper userRoleRelationMapper) {
        this.userRoleRelationMapper = userRoleRelationMapper;
    }

    public boolean insertUserRoleRelation(UserRoleRelationPO userRoleRelationPO) {
        return userRoleRelationMapper.insertOneUserRoleRelation(userRoleRelationPO) > 0;
    }

    public boolean deleteUserRoleRelation(long userId) {
        return userRoleRelationMapper.deleteUserRoleRelationByUserId(userId) >= 0;
    }
}
