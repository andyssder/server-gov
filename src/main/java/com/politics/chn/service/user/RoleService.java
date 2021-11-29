package com.politics.chn.service.user;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import com.politics.chn.repo.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author xu
 * @since 2021-04-05 10:59
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    private void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Long addRole(RoleDO roleDO) {
        Assert.isTrue(roleDO.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        Assert.isTrue(roleRepository.insertOne(roleDO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return roleDO.getId();
    }

    public void updateRole(RoleDO roleDO) {
        Assert.isTrue(roleRepository.updateOne(roleDO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void patchUpdateRole(List<RoleDO> roleDOS) {
        Assert.isTrue(roleRepository.updateMany(roleDOS), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<RoleDO> getRoleList() {
        return roleRepository.getAll();
    }

    public List<RoleDO> getRoleListByUser(long userId) {
        return roleRepository.getRolesByUserId(userId);

    }

    public void deleteRole(long id) {
        Assert.isTrue(roleRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public boolean addRolePermission(long roleId, long permissionId) {
        RolePermissionRelationPO rolePermissionRelationPO = new RolePermissionRelationPO(roleId, permissionId);
        return roleRepository.insertRolePermissionRelation(roleId, permissionId);
    }

    public boolean deletePermission(long roleId) {
        return roleRepository.deleteRolePermissionRelation(roleId);
    }


}
