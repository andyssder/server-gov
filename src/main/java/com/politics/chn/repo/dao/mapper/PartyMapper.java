package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.PartyDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-19 21:34
 */
@Mapper
public interface PartyMapper {
    @Select("SELECT * FROM party")
    List<PartyDO> getAll();

    @Select("SELECT * FROM party WHERE id = #{id}")
    PartyDO getOneById(int id);
}
