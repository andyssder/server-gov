package com.politics.chn.repo.dao.mapper;

import com.politics.chn.model.domain.entity.PersonDO;
import com.politics.chn.model.domain.value.PartyDO;
import com.politics.chn.model.po.PersonPO;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 * @author andyssder
 * @create 2021-02-18 17:41
 */
@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person")
    @Results(id="person", value={
            @Result(property="party",column="party_id",one=@One(select="com.politics.chn.repo.dao.mapper.PartyMapper.getOneById")),
            @Result(property="ethnicity",column="ethnicity_id",one=@One(select="com.politics.chn.repo.dao.mapper.EthnicityMapper.getOneById")),
            @Result(property="ancestralHome",column="ancestral_home",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property="birthPlace",column="birth_place",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById")),
            @Result(property="workPlace",column="work_place",one=@One(select="com.politics.chn.repo.dao.mapper.DistrictMapper.getOneById"))
    })
    List<PersonDO> getAll();

    @Select("SELECT * FROM person WHERE id = #{id}")
    @ResultMap("person")
    PersonPO getOneById(long id);

    @Insert("INSERT INTO person(" +
            "name, portrait, gender, ethnicity_id," +
            "birth_date, death_date, work_date, retire_date," +
            "ancestral_home, birth_place, work_place" +
            "university, major, education, degree," +
            "rank, creat_time, update_time, is_delete,) " +
            "VALUES(" +
            "#{name}, #{portrait}, #{gender}, #{ethnicityId}, " +
            "#{birthDate}, #{deathDate}, #{workDate}, #{retireDate}, " +
            "#{ancestralHome}, #{birthPlace}, #{workPlace}," +
            "#{university}, #{major}, #{education}, #{degree}," +
            "#{rank}, #{creatTime}, #{updateTime}, #{isDelete})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PersonPO personPO);

    @Update("<script> " +
            "UPDATE person SET" +
            "<foreach item='value' index='key' collection='updateParams.entrySet()' separator=','>" +
            "${key} = #{value}" +
            "</foreach>" +
            "WHERE id = #{id}" +
            "</script>")
    int updateOne(long id, Map<String, Object> updateParams);

    @Update("UPDATE person SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM person WHERE id = #{id}")
    int realDeleteOne(long id);
}
