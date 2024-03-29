package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.query.PermissionQuery;
import com.politics.chn.domain.user.repository.PermissionRepository;
import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.po.PermissionPO;
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
public class PermissionRepositoryImpl implements PermissionRepository {

    private PermissionDao permissionDao;

    @Autowired
    private void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    @Override
    public Permission find(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public List<Permission> query(PermissionQuery query) {
        if (Objects.nonNull(query.getRoleId())) {
            return getPermissionsByRoleId(query.getRoleId());
        } else if (CollectionUtil.isNotEmpty(query.getRoleIds())) {
            return getPermissionsByRoleIds(query.getRoleIds());
        }
        return getAll();
    }

    private List<Permission> getPermissionsByRoleId(long roleId) {
        List<PermissionPO> list = permissionDao.getPermissionsByRoleId(roleId);
        return list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, Permission.class)).collect(Collectors.toList());
    }

    private List<Permission> getPermissionsByRoleIds(List<Long> roleIds) {
        List<PermissionPO> list = permissionDao.getPermissionsByRoleIds(roleIds);
        return list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, Permission.class)).collect(Collectors.toList());
    }

    private List<Permission> getAll() {
        List<PermissionPO> list = permissionDao.getAll();
        return list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, Permission.class)).collect(Collectors.toList());
    }


    @Override
    public boolean remove(Long id) {
        return permissionDao.deleteOne(id);
    }

    @Override
    public boolean save(Permission permission) {
        if (Objects.isNull(permission.getId())) {
            return insertOne(permission);
        } else {
            return updateOne(permission);
        }
    }

    public boolean insertOne(Permission permission) {
        PermissionPO permissionPO = BeanUtil.toBean(permission, PermissionPO.class);
        permissionPO.setCreateTime(new Date());
        if (!permissionDao.insertOne(permissionPO)) {
            return false;
        }
        permission.setId(permissionPO.getId());
        return true;
    }

    public boolean updateOne(Permission permission) {
        PermissionPO permissionPO = BeanUtil.toBean(permission, PermissionPO.class);
        return permissionDao.updateOne(permissionPO);
    }

}
