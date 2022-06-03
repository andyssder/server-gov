package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.entity.Role;
import com.politics.chn.domain.user.query.RoleQuery;
import com.politics.chn.domain.user.repository.RoleRepository;
import com.politics.chn.repo.user.dao.RoleDao;
import com.politics.chn.repo.user.dao.RolePermissionRelationDao;
import com.politics.chn.repo.user.po.RolePO;
import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2021-04-05 11:00
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

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

    @Override
    public Role find(Long id) {

        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public List<Role> query(RoleQuery query) {
        if (Objects.nonNull(query.getUserId())) {
            return getRolesByUserId(query.getUserId());
        }
        return getAll();
    }

    private List<Role> getAll() {
        List<RolePO> list = roleDao.getAll();
        return list.stream().map(rolePO -> BeanUtil.toBean(rolePO, Role.class)).collect(Collectors.toList());
    }

    private List<Role> getRolesByUserId(long userId) {
        List<RolePO> list = roleDao.getRolesByUserId(userId);
        return list.stream().map(rolePO -> BeanUtil.toBean(rolePO, Role.class)).collect(Collectors.toList());
    }


    @Override
    public boolean remove(Long id) {
        return false;
    }

    @Override
    public boolean save(Role role) {
        if (Objects.isNull(role.getId())) {
            return insertOne(role);
        } else {
            return updateOne(role);
        }
    }

    private boolean insertOne(Role role) {
        RolePO rolePO = BeanUtil.toBean(role, RolePO.class);
        rolePO.setCreateTime(new Date());
        if (!roleDao.insertOne(rolePO)) {
            return false;
        }
        role.setId(role.getId());
        return true;
    }

    private boolean updateOne(Role role) {
        RolePO rolePO = BeanUtil.toBean(role, RolePO.class);
        return roleDao.updateOne(rolePO);
    }

    public boolean deleteOne(long id) {
        return roleDao.deleteOne(id);
    }


    @Override
    public Boolean insertRolePermissionRelation(long roleId, long permissionId) {
        RolePermissionRelationPO rolePermissionRelationPO = new RolePermissionRelationPO(roleId, permissionId);
        return rolePermissionRelationDao.insertRolePermissionRelation(rolePermissionRelationPO);
    }

    @Override
    public Boolean deleteRolePermissionRelation(long roleId) {
        return rolePermissionRelationDao.deleteRolePermissionRelation(roleId);
    }
}
