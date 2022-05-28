package com.politics.chn.domain.user.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.user.entity.Role;

/**
 * @author andyssder
 * @since 2021-12-05
 */
public class RoleQuery implements Query<Role> {
    Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
