package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.PermissionDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:46
 */
@Mapper
public interface PermissionMapper {
    // TODO 优化查询代码, 考虑user role permission 怎么更好的查询
    @Select("<script> " +
            "SELECT p.* " +
            "FROM " +
            "sys_user_role ur " +
            "LEFT JOIN sys_role r ON r.id=ur.role_id " +
            "LEFT JOIN sys_role_permission rp ON rp.role_id=r.id " +
            "LEFT JOIN sys_permission p ON p.id=rp.permission_id " +
            "WHERE " +
            "ur.user_id=#{userId} " +
            "AND p.id IS NOT NULL" +
            "</script>")
    List<PermissionDO> getListByUserId(long userId);
}
