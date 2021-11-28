package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.EthnicityPO;
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
    List<EthnicityPO> getAll();

    @Select("SELECT * FROM ethnicity WHERE id = #{id} LIMIT 1")
    EthnicityPO getOneById(int id);
}
