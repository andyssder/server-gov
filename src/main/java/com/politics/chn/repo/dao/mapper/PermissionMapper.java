package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.PermissionDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:46
 */
@Mapper
public interface PermissionMapper {

    @Select("SELECT * FROM sys_permission where is_deleted = false")
    @Results(id="permission", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<PermissionDO> getAll();

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
    @ResultMap("permission")
    List<PermissionDO> getListByUserId(long userId);

    @Insert("INSERT INTO sys_permission(pid, name, description, type, uri, sort, create_time) " +
            "VALUES(#{pid}, #{name}, #{description}, #{type}, #{uri}, #{sort}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PermissionDO permission);

    @Update("<script> " +
            "UPDATE sys_permission" +
            "<trim prefix='set' suffixOverrides=',' suffix=' where id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='description != null'> description=#{description}, </if>" +
            "<if test='type != null'> type=#{type}, </if>" +
            "<if test='uri != null'> uri=#{uri}, </if>" +
            "<if test='sort != null'> sort=#{sort}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PermissionDO permission);

    @Update("UPDATE sys_permission SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM sys_permission WHERE id = #{id}")
    int realDeleteOne(long id);
}
