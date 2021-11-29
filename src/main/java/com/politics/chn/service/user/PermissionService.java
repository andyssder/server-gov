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
        Assert.isTrue(permissionRepository.insertOne(permissionDO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return permissionDO.getId();
    }

    public void updatePermission(PermissionDO permissionDO) {
        Assert.isTrue(permissionRepository.updateOne(permissionDO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void patchUpdatePermission(List<PermissionDO> permissionDOS) {
        Assert.isTrue(permissionRepository.updateMany(permissionDOS), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<PermissionDO> getPermissionList() {
        return permissionRepository.getAll();
    }

    public List<PermissionDO> getPermissionListByRole(long roleId) {
        return permissionRepository.getPermissionsByRoleId(roleId);
    }

    public void deletePermission(long id) {
        Assert.isTrue(permissionRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

}
