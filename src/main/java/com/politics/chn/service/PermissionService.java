package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.repo.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 11:00
 */
@Service
public class PermissionService {
    private PermissionRepository permissionRepository;

    @Autowired
    private void setPermissionRepository(PermissionRepository permissionRepository) {
        this.permissionRepository = permissionRepository;
    }

    public Long addPermission(PermissionDO permission) {
        Assert.isTrue(permission.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        permission.setCreateTime(new Date());
        Assert.isTrue(permissionRepository.insertOne(permission), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return permission.getId();
    }

    public void updatePermission(PermissionDO permission) {
        Assert.isTrue(permissionRepository.updateOne(permission), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<PermissionDO> getPermissionList() {
        return permissionRepository.getAll();
    }

    public void deletePermission(long id) {
        Assert.isTrue(permissionRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }
}