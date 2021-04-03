package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserInfoDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-03 21:52
 */
@Mapper
public interface RoleMapper {
    // mysql不对
    @Select("SELECT * FROM role WHERE userId = #{userId}")
    List<RoleDO> getListByUserId(long userId);
}
