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
    // mysql不对
    @Select("SELECT * FROM permission WHERE userId = #{userId}")
    List<PermissionDO> getListByUserId(long userId);
}
