package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.PartyPO;
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
    List<PartyPO> getAll();

    @Select("SELECT * FROM party WHERE id = #{id} LIMIT 1")
    PartyPO getOneById(int id);
}
