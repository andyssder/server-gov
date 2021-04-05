package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.RoleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:52
 */
@Mapper
public interface RoleMapper {
    @Select("<script> " +
            "SELECT r.* " +
            "FROM sys_role r, sys_user_role ur " +
            "WHERE ur.user_id=#{userId} AND ur.role_id=r.id" +
            "</script>")
    List<RoleDO> getListByUserId(long userId);
}
