package com.politics.chn.repo.user.repository;

import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.repo.user.po.RolePO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-04-05 11:00
 */
@Repository
public class RoleRepository {

    private RoleDao roleDao;

    @Autowired
    private void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<RolePO> getAll() {
        return roleDao.getAll();
    }

    public List<RolePO> getRolesByUserId(long userId) {
        return roleDao.getRolesByUserId(userId);
    }

    public boolean insertOne(RolePO role) {
        return roleDao.insertOne(role);
    }

    public boolean updateOne(RolePO role) {
        return roleDao.updateOne(role);
    }

    public boolean updateMany(List<RolePO> roles) {
        return roleDao.updateMany(roles);
    }

    public boolean deleteOne(long id) {
        return roleDao.deleteOne(id);
    }

    public List<RolePO> getRoleListByUserId(long userId) {
        return roleDao.getRolesByUserId(userId);
    }
}
