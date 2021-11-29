package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.repo.user.dao.PermissionDao;
import com.politics.chn.repo.user.po.PermissionPO;
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
public class PermissionRepository {

    private PermissionDao permissionDao;

    @Autowired
    private void setPermissionDao(PermissionDao permissionDao) {
        this.permissionDao = permissionDao;
    }

    public List<PermissionDO> getPermissionsByRoleId(long roleId) {
        List<PermissionPO> list = permissionDao.getPermissionsByRoleId(roleId);
        return list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, PermissionDO.class)).collect(Collectors.toList());
    }

    public List<PermissionDO> getAll() {
        List<PermissionPO> list = permissionDao.getAll();
        return list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, PermissionDO.class)).collect(Collectors.toList());
    }

    public boolean insertOne(PermissionDO permissionDO) {
        PermissionPO permissionPO = BeanUtil.toBean(permissionDO, PermissionPO.class);
        permissionPO.setCreateTime(new Date());
        if (!permissionDao.insertOne(permissionPO)) {
            return false;
        }
        permissionDO.setId(permissionPO.getId());
        return true;
    }

    public boolean updateOne(PermissionDO permissionDO) {
        PermissionPO permissionPO = BeanUtil.toBean(permissionDO, PermissionPO.class);
        return permissionDao.updateOne(permissionPO);
    }

    public boolean updateMany(List<PermissionDO> permissionDOS) {
        List<PermissionPO> permissionPOS = permissionDOS.stream().map(permissionDO -> BeanUtil.toBean(permissionDO, PermissionPO.class)).collect(Collectors.toList());
        return permissionDao.updateMany(permissionPOS);
    }

    public boolean deleteOne(long id) {
        return permissionDao.deleteOne(id);
    }

}
