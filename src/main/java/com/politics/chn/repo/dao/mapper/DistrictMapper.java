package com.politics.chn.repo.dao.mapper;


import com.politics.chn.model.domain.value.DistrictDO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:45
 */
@Mapper
public interface DistrictMapper {

    @Select("SELECT * FROM district where level != 0")
    List<DistrictDO> getAll();

    @Select("SELECT * FROM district WHERE level = #{level}")
    List<DistrictDO> getByLevel(int level);

    @Select("SELECT * FROM district WHERE lft < #{lft} AND rgt > #{rgt} ORDER BY lft ASC")
    List<DistrictDO> getUpper(int lft, int rgt);

    @Select("SELECT * FROM district WHERE lft > #{lft} AND rgt < #{rgt} AND level=#{level} + 1 ORDER BY lft ASC")
    List<DistrictDO> getLower(int lft, int rgt, int level);

    @Select("SELECT * FROM district WHERE id = #{id}")
    @Results(id="district", value={
            @Result(property = "names", javaType = List.class, column = "{lft = lft, rgt = rgt}",
                    many = @Many(select = "com.politics.chn.repo.dao.mapper.DistrictMapper.getUpperNames"))
    })
    DistrictDO getOneById(int id);

    @Select("SELECT name FROM district WHERE lft < #{lft} AND rgt > #{rgt} ORDER BY lft ASC")
    List<String> getUpperNames(int lft, int rgt);
}
