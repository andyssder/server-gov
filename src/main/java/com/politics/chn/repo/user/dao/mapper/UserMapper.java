package com.politics.chn.repo.user.dao.mapper;

import com.politics.chn.repo.user.po.UserPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author andyssder
 * @since 2021-03-31 22:32
 */
@Mapper
public interface UserMapper {

    @Select("SELECT * FROM sys_user WHERE is_deleted = false")
    @Results(id="user", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted")
    })
    List<UserPO> getAll();

    @Select("SELECT * FROM sys_user WHERE ${field} = #{value} LIMIT 1")
    @ResultMap("user")
    UserPO getOneByField(String field, String value);

    @Insert("INSERT INTO sys_user(username, password, icon, description, email, phone, create_time) VALUES(#{username}, #{password}, #{icon}, #{description}, #{email}, #{phone}, #{createTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(UserPO baseUser);

}
