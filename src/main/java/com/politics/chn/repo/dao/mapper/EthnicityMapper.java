package com.politics.chn.repo.dao.mapper;

import com.politics.chn.domain.official.value.EthnicityDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Mapper
public interface EthnicityMapper {

    @Select("SELECT * FROM ethnicity")
    List<EthnicityDO> getAll();

    @Select("SELECT * FROM ethnicity WHERE id = #{id} LIMIT 1")
    EthnicityDO getOneById(int id);
}
