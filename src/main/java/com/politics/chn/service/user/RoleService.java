package com.politics.chn.service.user;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.entity.Role;
import com.politics.chn.domain.user.query.RoleQuery;
import com.politics.chn.domain.user.repository.RoleRepository;
import com.politics.chn.repo.user.po.RolePermissionRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author andyssder
 * @since 2021-04-05 10:59
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    private void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Long addRole(Role role) {
//        Assert.isTrue(role.isNotNull(), () -> {
//            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
//        });

        Assert.isTrue(roleRepository.save(role), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return role.getId();
    }

    public void updateRole(Role role) {
        Assert.isTrue(roleRepository.save(role), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    @Transactional(rollbackFor = Exception.class)
    public void patchUpdateRole(List<Role> roles) {
        roles.forEach(roleDO -> {
            Assert.isTrue(roleRepository.save(roleDO), () -> {
                throw new CommonException(ResultStatusEnum.NOT_FOUND);
            });
        });
    }

    public List<Role> getRoleList() {
        return roleRepository.query(new RoleQuery());
    }

    public List<Role> getRoleListByUser(long userId) {
        RoleQuery roleQuery = new RoleQuery();
        roleQuery.setUserId(userId);
        return roleRepository.query(roleQuery);

    }

    public void deleteRole(long id) {
        Assert.isTrue(roleRepository.remove(id), () -> {
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
