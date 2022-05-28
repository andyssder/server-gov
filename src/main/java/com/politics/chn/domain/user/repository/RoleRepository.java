package com.politics.chn.domain.user.repository;

import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.user.entity.Role;
import com.politics.chn.domain.user.query.RoleQuery;

/**
 * @author andyssder
 * @since 2021-12-05
 */
public interface RoleRepository extends Repository<Role, RoleQuery> {
    Boolean insertRolePermissionRelation(long roleId, long permissionId);

    Boolean deleteRolePermissionRelation(long roleId);
}
