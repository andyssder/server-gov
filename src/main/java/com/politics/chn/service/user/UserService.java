package com.politics.chn.service.user;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.user.po.UserRoleRelationPO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.user.repository.BaseUserRepository;
import com.politics.chn.repo.user.repository.UserRoleRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-03-31 22:30
 */
@Repository
public class UserService {

    private BaseUserRepository baseUserRepository;
    private UserRoleRelationRepository userRoleRelationRepository;
    private RoleService roleService;
    private PermissionService permissionService;

    @Autowired
    public void setBaseUserRepository(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public UserDO getUserByField(String field, String value) {
        BaseUserDO baseUserDO = baseUserRepository.getOneByField(field, value);
        if (baseUserDO == null) {
            return null;
        }

        long id = baseUserDO.getId();
        List<RoleDO> roles = roleService.getRoleListByUser(id);
        List<PermissionDO> permissions = permissionService.getPermissionListByRole(id);

        UserDO userDO = new UserDO(baseUserDO, roles, permissions);
        return userDO;
    }

    public boolean addUser(BaseUserDO baseUserDO) {
        return baseUserRepository.addUser(baseUserDO);
    }

    public List<BaseUserDO> getAll() {
        return baseUserRepository.getAll();
    }

    public boolean deleteUserRole(long userId) {
        return baseUserRepository.deleteUserRoleRelation(userId);
    }

    public boolean addUserRole(long userId, long roleId) {
        return baseUserRepository.insertUserRoleRelation(userId, roleId);
    }
}
