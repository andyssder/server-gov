package com.politics.chn.domain.user.repository;

import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.query.PermissionQuery;

/**
 * @author xu
 * @since 2021-12-05
 */
public interface PermissionRepository extends Repository<Permission, PermissionQuery> {
}
