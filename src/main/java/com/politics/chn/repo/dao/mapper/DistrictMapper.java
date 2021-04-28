package com.politics.chn.repo.dao.mapper;


import com.politics.chn.domain.official.value.DistrictDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-06
 * @author andyssder
 */
@Mapper
public interface DistrictMapper {

    @Select("SELECT * FROM district WHERE level != 0")
    List<DistrictDO> getAll();

    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
    DistrictDO getOneById(int id);

    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
    @Results(id="districtParents", value={
            @Result(property = "parents", javaType = List.class, column = "{lft = lft, rgt = rgt}",
                    many = @Many(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getUpper"))
    })
    DistrictDO getOneByIdWithParents(int id);

    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
    @Results(id="districtChildren", value={
            @Result(property = "children", javaType = List.class, column = "{lft = lft, rgt = rgt, level = level}",
                    many = @Many(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getLower"))
    })
    DistrictDO getOneByIdWithChildren(int id);

    @Select("SELECT * FROM district WHERE level = #{level}")
    List<DistrictDO> getByLevel(int level);

    @Select("SELECT * FROM district WHERE lft < #{lft} AND rgt > #{rgt} and level != 0 ORDER BY lft ASC")
    List<DistrictDO> getUpper(int lft, int rgt);

    @Select("SELECT * FROM district WHERE lft > #{lft} AND rgt < #{rgt} AND level=#{level} + 1 ORDER BY lft ASC")
    List<DistrictDO> getLower(int lft, int rgt, int level);

}
