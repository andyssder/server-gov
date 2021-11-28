package com.politics.chn.service.user;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.repo.user.po.PermissionPO;
import com.politics.chn.repo.user.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-04-05 11:00
 */
@Service
public class PermissionService {
    private PermissionRepository permissionRepository;

    @Autowired
    private void setPermissionRepository(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Long addPermission(PermissionDO permissionDO) {
        Assert.isTrue(permissionDO.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        PermissionPO permission = BeanUtil.toBean(permissionDO, PermissionPO.class);
        permission.setCreateTime(new Date());
        Assert.isTrue(permissionRepository.insertOne(permission), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return permission.getId();
    }

    public void updatePermission(PermissionDO permissionDO) {
        PermissionPO permission = BeanUtil.toBean(permissionDO, PermissionPO.class);
        permission.setCreateTime(new Date());
        Assert.isTrue(permissionRepository.updateOne(permission), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void patchUpdatePermission(List<PermissionDO> permissionDOS) {
        List<PermissionPO> permissions = permissionDOS.stream().map(permissionDO -> BeanUtil.toBean(permissionDO, PermissionPO.class)).collect(Collectors.toList());

        Assert.isTrue(permissionRepository.updateMany(permissions), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<PermissionDO> getPermissionList() {
        List<PermissionPO> list = permissionRepository.getAll();
        List<PermissionDO> result = list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, PermissionDO.class)).collect(Collectors.toList());

        return result;
    }

    public List<PermissionDO> getPermissionListByRole(long roleId) {
        List<PermissionPO> list = permissionRepository.getPermissionsByRoleId(roleId);
        List<PermissionDO> result = list.stream().map(permissionPO -> BeanUtil.toBean(permissionPO, PermissionDO.class)).collect(Collectors.toList());

        return result;
    }

    public void deletePermission(long id) {
        Assert.isTrue(permissionRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

}
