package com.politics.chn.repo.dao.mapper;


import com.politics.chn.model.po.DistrictPO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author: andyssder
 * @create: 2021-02-06 16:45
 */
@Mapper
public interface DistrictMapper {

    @Select("SELECT * FROM district where level != 0")
    List<DistrictPO> getAll();

    @Select("SELECT * FROM district WHERE level = #{level}")
    List<DistrictPO> getByLevel(int level);

    @Select("SELECT * FROM district WHERE lbb < #{lbb} AND ubb > #{ubb} ORDER BY lbb ASC")
    List<DistrictPO> getUpper(int lbb, int ubb);

    @Select("SELECT * FROM district WHERE lbb > #{lbb} AND ubb < #{ubb} AND level=#{level} + 1 ORDER BY lbb ASC")
    List<DistrictPO> getLower(int lbb, int ubb, int level);

    @Select("SELECT * FROM district WHERE id = #{id}")
    DistrictPO getOneById(int id);

}
