package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @author xu
 * @create 2021-03-31 22:32
 */
@Mapper
public interface UserInfoMapper {
    @Select("SELECT * FROM user WHERE #{field} = #{value}")
    UserInfoDO getOneById(String field, String value);
}
