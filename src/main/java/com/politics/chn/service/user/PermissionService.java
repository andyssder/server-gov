package com.politics.chn.service.user;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.query.PermissionQuery;
import com.politics.chn.domain.user.repository.PermissionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

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

    public Long addPermission(Permission permission) {
//        Assert.isTrue(permission.isNotNull(), () -> {
//            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
//        });
        Assert.isTrue(permissionRepository.save(permission), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return permission.getId();
    }

    public void updatePermission(Permission permission) {
        Assert.isTrue(permissionRepository.save(permission), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void patchUpdatePermissions(List<Permission> permissions) {
        permissions.forEach(permissionDO -> {
            Assert.isTrue(permissionRepository.save(permissionDO), () -> {
                throw new CommonException(ResultStatusEnum.NOT_FOUND);
            });
        });
    }

    public List<Permission> getPermissionList() {
        return permissionRepository.query(new PermissionQuery());
    }

    public List<Permission> getPermissionListByRole(long roleId) {
        PermissionQuery permissionQuery = new PermissionQuery();
        permissionQuery.setRoleId(roleId);
        return permissionRepository.query(permissionQuery);
    }

    public void deletePermission(long id) {
        Assert.isTrue(permissionRepository.remove(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

}
