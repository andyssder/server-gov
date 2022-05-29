package com.politics.chn.domain.user.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.user.entity.Permission;

import java.util.List;

/**
 * @author andyssder
 * @since 2021-12-05
 */
public class PermissionQuery implements Query<Permission> {
    Long roleId;

    List<Long> roleIds;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public List<Long> getRoleIds() {
        return roleIds;
    }

    public void setRoleIds(List<Long> roleIds) {
        this.roleIds = roleIds;
    }
}
