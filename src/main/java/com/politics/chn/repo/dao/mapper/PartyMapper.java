package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.official.value.PartyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Mapper
public interface PartyMapper {
    @Select("SELECT * FROM party")
    List<PartyDO> getAll();

    @Select("SELECT * FROM party WHERE id = #{id} LIMIT 1")
    PartyDO getOneById(int id);
}
