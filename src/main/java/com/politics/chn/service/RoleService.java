package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.repo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 10:59
 */
@Service
public class RoleService {
    private RoleRepository roleRepository;

    @Autowired
    private void setRoleRepository(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Long addRole(RoleDO role) {
        Assert.isTrue(role.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        role.setCreateTime(new Date());
        Assert.isTrue(roleRepository.insertOne(role), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return role.getId();
    }

    public void updateRole(RoleDO role) {
        Assert.isTrue(roleRepository.updateOne(role), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<RoleDO> getRoleList() {
        return roleRepository.getAll();
    }

    public void deleteRole(long id) {
        Assert.isTrue(roleRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }
}
