package com.politics.chn.service.user;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.repo.user.po.RolePO;
import com.politics.chn.repo.user.repository.RolePermissionRelationRepository;
import com.politics.chn.repo.user.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-04-05 10:59
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    private RolePermissionRelationRepository permissionRelationRepository;

    @Autowired
    private void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Long addRole(RoleDO roleDO) {
        Assert.isTrue(roleDO.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        RolePO rolePO = BeanUtil.toBean(roleDO, RolePO.class);
        rolePO.setCreateTime(new Date());
        Assert.isTrue(roleRepository.insertOne(rolePO), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return rolePO.getId();
    }

    public void updateRole(RoleDO roleDO) {
        RolePO rolePO = BeanUtil.toBean(roleDO, RolePO.class);
        Assert.isTrue(roleRepository.updateOne(rolePO), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void patchUpdateRole(List<RoleDO> roleDOS) {
        List<RolePO> rolePOS = roleDOS.stream().map(roleDO -> BeanUtil.toBean(roleDO, RolePO.class)).collect(Collectors.toList());
        Assert.isTrue(roleRepository.updateMany(rolePOS), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<RoleDO> getRoleList() {

        List<RolePO> list = roleRepository.getAll();

        List<RoleDO> result = list.stream().map(rolePO -> BeanUtil.toBean(rolePO, RoleDO.class)).collect(Collectors.toList());
        return result;
    }

    public List<RoleDO> getRoleListByUser(long userId) {

        List<RolePO> list = roleRepository.getRolesByUserId(userId);

        List<RoleDO> result = list.stream().map(rolePO -> BeanUtil.toBean(rolePO, RoleDO.class)).collect(Collectors.toList());
        return result;
    }

    public void deleteRole(long id) {
        Assert.isTrue(roleRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }
    public boolean addRolePermission(long roleId, long permissionId) {
        RolePermissionRelation rolePermissionRelation = new RolePermissionRelation(roleId, permissionId);
        return permissionRelationRepository.insertRolePermissionRelation(rolePermissionRelation);
    }

    public boolean deletePermission(long roleId) {
        return permissionRelationRepository.deleteRolePermissionRelation(roleId);
    }


}
