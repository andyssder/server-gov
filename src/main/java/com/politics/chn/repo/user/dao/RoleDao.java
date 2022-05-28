package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.dao.mapper.RoleMapper;
import com.politics.chn.repo.user.po.RolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author andyssder
 * @since 2021-04-01 20:30
 */
@Repository
public class RoleDao {

    private RoleMapper roleMapper;

    @Autowired
    public void setRoleMapper(RoleMapper roleMapper) {
        this.roleMapper = roleMapper;
    }

    public List<RolePO> getRolesByUserId(long userId) {
        return roleMapper.getListByUserId(userId);
    }

    public List<RolePO> getAll() {
        return roleMapper.getAll();
    }

    public boolean insertOne(RolePO role) {
        return roleMapper.insertOne(role) > 0;
    }

    public boolean updateOne(RolePO role) {
        return roleMapper.updateOne(role) > 0;
    }

    public boolean updateMany(List<RolePO> roles) {
        return roleMapper.updateMany(roles) == roles.size();
    }

    public boolean deleteOne(long id) {
        return roleMapper.deleteOne(id) > 0;
    }

}
