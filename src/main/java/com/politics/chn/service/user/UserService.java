package com.politics.chn.service.user;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.user.po.BaseUserPO;
import com.politics.chn.repo.user.repository.BaseUserRepository;
import com.politics.chn.repo.user.repository.UserRoleRelationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

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
    public void setUserRoleRelationRepository(UserRoleRelationRepository userRoleRelationRepository) {
        this.userRoleRelationRepository = userRoleRelationRepository;
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
        BaseUserPO baseUserPO = baseUserRepository.getOneByField(field, value);
        if (baseUserPO == null) {
            return null;
        }

        BaseUserDO baseUserDO = BeanUtil.toBean(baseUserPO, BaseUserDO.class);

        long id = baseUserDO.getId();
        List<RoleDO> roles = roleService.getRoleListByUser(id);
        List<PermissionDO> permissions = permissionService.getPermissionListByRole(id);

        UserDO userDO = new UserDO(baseUserDO, roles, permissions);
        return userDO;
    }

    public boolean addUser(BaseUserDO baseUserDO) {
        BaseUserPO baseUserPO = BeanUtil.toBean(baseUserDO, BaseUserPO.class);
        return baseUserRepository.addUser(baseUserPO);
    }

    public List<BaseUserDO> getAll() {
        List<BaseUserPO> list = baseUserRepository.getAll();

        List<BaseUserDO> result = list.stream().map(baseUserPO -> BeanUtil.toBean(baseUserPO, BaseUserDO.class)).collect(Collectors.toList());

        return result;
    }

    public boolean deleteUserRole(long userId) {
        return userRoleRelationRepository.deleteUserRoleRelation(userId);
    }

    public boolean addUserRole(long userId, long roleId) {
        UserRoleRelation userRoleRelation = new UserRoleRelation(userId, roleId);
        return userRoleRelationRepository.insertUserRoleRelation(userRoleRelation);
    }
}
