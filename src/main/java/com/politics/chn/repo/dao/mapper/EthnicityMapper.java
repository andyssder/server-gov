package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.value.EthnicityDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-19 21:32
 */
@Mapper
public interface EthnicityMapper {

    @Select("SELECT * FROM ethnicity")
    List<EthnicityDO> getAll();

    @Select("SELECT * FROM ethnicity WHERE id = #{id}")
    EthnicityDO getOneById(int id);
}
