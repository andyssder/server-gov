package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import com.politics.chn.repo.dao.mapper.BaseUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-03-31 22:31
 */
@Repository
public class BaseUserDao {
    private BaseUserMapper baseUserMapper;

    @Autowired
    public void setBaseUserMapper(BaseUserMapper baseUserMapper) {
        this.baseUserMapper = baseUserMapper;
    }

    public BaseUserDO getOneByField(String field, String value) {
        return baseUserMapper.getOneByField(field, value);
    }

    public boolean insertOne(BaseUserDO baseUser) {
        return baseUserMapper.insertOne(baseUser) > 0;
    }

    public List<BaseUserDO> getAll() {
        return baseUserMapper.getAll();
    }

    public boolean insertUserRoleRelation(UserRoleRelation userRoleRelation) {
        return baseUserMapper.insertOneUserRoleRelation(userRoleRelation) > 0;
    }

    public boolean deleteUserRoleRelation(long userId) {
        return baseUserMapper.deleteUserRoleRelationByUserId(userId) >= 0;
    }
}
