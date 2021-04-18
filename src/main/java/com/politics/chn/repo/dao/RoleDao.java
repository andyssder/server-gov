package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import com.politics.chn.repo.dao.mapper.RoleMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-01 20:30
 */
@Repository
public class RoleDao {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<RoleDO> getRolesByUserId(long userId) {
        return roleMapper.getListByUserId(userId);
    }

    public List<RoleDO> getAll() {
        return roleMapper.getAll();
    }

    public boolean insertOne(RoleDO role) {
        return roleMapper.insertOne(role) > 0;
    }

    public boolean updateOne(RoleDO role) {
        return roleMapper.updateOne(role) > 0;
    }

    public boolean updateMany(List<RoleDO> roles) {
        return roleMapper.updateMany(roles) == roles.size();
    }

    public boolean deleteOne(long id) {
        return deleteOne(id, false);
    }

    public boolean deleteOne(long id, boolean realDelete) {
        return realDelete ? roleMapper.realDeleteOne(id) > 0 : roleMapper.deleteOne(id) > 0;
    }

    public boolean insertUserRoleRelation(UserRoleRelation userRoleRelation) {
        return roleMapper.insertOneUserRoleRelation(userRoleRelation) > 0;
    }

    public boolean deleteUserRoleRelation(long userId) {
        return roleMapper.deleteUserRoleRelationByUserId(userId) > 0;
    }
}
