package com.politics.chn.repo.official.dao.mapper;


import com.politics.chn.repo.official.po.DistrictPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-06
 * @author andyssder
 */
@Mapper
public interface DistrictMapper {

    @Select("SELECT * FROM district WHERE level != 0")
    List<DistrictPO> getAll();

    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
    DistrictPO getOneById(int id);

//    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
//    @Results(id="districtParents", value={
//            @Result(property = "parents", javaType = List.class, column = "{lft = lft, rgt = rgt}",
//                    many = @Many(select = "com.politics.chn.repo.official.dao.mapper.DistrictMapper.getUpper"))
//    })
//    DistrictPO getOneByIdWithParents(int id);
//
//    @Select("SELECT * FROM district WHERE id = #{id} LIMIT 1")
//    @Results(id="districtChildren", value={
//            @Result(property = "children", javaType = List.class, column = "{lft = lft, rgt = rgt, level = level}",
//                    many = @Many(select = "com.politics.chn.repo.official.dao.mapper.DistrictMapper.getLower"))
//    })
//    DistrictPO getOneByIdWithChildren(int id);

    @Select("SELECT * FROM district WHERE level = #{level}")
    List<DistrictPO> getByLevel(int level);

    @Select("SELECT * FROM district WHERE lft < #{lft} AND rgt > #{rgt} and level != 0 ORDER BY lft ASC")
    List<DistrictPO> getUpper(int lft, int rgt);

    @Select("SELECT * FROM district WHERE lft > #{lft} AND rgt < #{rgt} AND level=#{level} + 1 ORDER BY lft ASC")
    List<DistrictPO> getLower(int lft, int rgt, int level);

}
