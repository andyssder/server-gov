package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.repo.user.dao.RolePermissionRelationDao;
import com.politics.chn.repo.user.po.RolePO;
import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-04-05 11:00
 */
@Repository
public class RoleRepository {

    private RoleDao roleDao;

    private RolePermissionRelationDao rolePermissionRelationDao;

    @Autowired
    private void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Autowired
    public void setRolePermissionRelationDao(RolePermissionRelationDao rolePermissionRelationDao) {
        this.rolePermissionRelationDao = rolePermissionRelationDao;
    }

    public List<RoleDO> getAll() {
        List<RolePO> list = roleDao.getAll();
        return list.stream().map(rolePO -> BeanUtil.toBean(rolePO, RoleDO.class)).collect(Collectors.toList());
    }

    public List<RoleDO> getRolesByUserId(long userId) {
        List<RolePO> list = roleDao.getRolesByUserId(userId);
        return list.stream().map(rolePO -> BeanUtil.toBean(rolePO, RoleDO.class)).collect(Collectors.toList());
    }

    public List<RoleDO> getRoleListByUserId(long userId) {
        List<RolePO> list = roleDao.getRolesByUserId(userId);
        return list.stream().map(rolePO -> BeanUtil.toBean(rolePO, RoleDO.class)).collect(Collectors.toList());
    }

    public boolean insertOne(RoleDO roleDO) {
        RolePO rolePO = BeanUtil.toBean(roleDO, RolePO.class);
        rolePO.setCreateTime(new Date());
        if (!roleDao.insertOne(rolePO)) {
            return false;
        }
        roleDO.setId(roleDO.getId());
        return true;
    }

    public boolean updateOne(RoleDO roleDO) {
        RolePO rolePO = BeanUtil.toBean(roleDO, RolePO.class);
        return roleDao.updateOne(rolePO);
    }

    public boolean updateMany(List<RoleDO> roleDOS) {
        List<RolePO> rolePOS = roleDOS.stream().map(roleDO -> BeanUtil.toBean(roleDO, RolePO.class)).collect(Collectors.toList());
        return roleDao.updateMany(rolePOS);
    }

    public boolean deleteOne(long id) {
        return roleDao.deleteOne(id);
    }


    public boolean insertRolePermissionRelation(long roleId, long permissionId) {
        RolePermissionRelationPO rolePermissionRelationPO = new RolePermissionRelationPO(roleId, permissionId);
        return rolePermissionRelationDao.insertRolePermissionRelation(rolePermissionRelationPO);
    }

    public boolean deleteRolePermissionRelation(long roleId) {
        return rolePermissionRelationDao.deleteRolePermissionRelation(roleId);
    }
}
