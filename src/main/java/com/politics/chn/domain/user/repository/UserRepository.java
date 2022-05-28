package com.politics.chn.domain.user.repository;

import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.user.entity.User;
import com.politics.chn.domain.user.query.UserQuery;
import com.politics.chn.repo.user.po.UserRoleRelationPO;

import javax.validation.constraints.NotNull;


/**
 * @author andyssder
 * @since 2021-12-05
 */
public interface UserRepository extends Repository<User, UserQuery> {

    User queryOne(@NotNull UserQuery query);

    Boolean deleteUserRoleRelation(long userId);

    Boolean insertUserRoleRelation(long userId, long roleId);
}
