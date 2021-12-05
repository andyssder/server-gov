package com.politics.chn.domain.user.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.user.entity.Permission;

/**
 * @author xu
 * @since 2021-12-05
 */
public class PermissionQuery implements Query<Permission> {
    Long roleId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }
}
