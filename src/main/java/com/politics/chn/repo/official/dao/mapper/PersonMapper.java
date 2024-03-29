package com.politics.chn.repo.official.dao.mapper;

import com.politics.chn.repo.official.po.PersonPO;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @since 2021-02-18
 * @author andyssder
 */
@Mapper
public interface PersonMapper {

    @Select("SELECT * FROM person WHERE is_deleted = false")
    @Results(id="person", value={
            @Result(property="enabled",column="is_enabled"),
            @Result(property="deleted",column="is_deleted"),
            @Result(property="ancestralHomeId",column="ancestral_home"),
            @Result(property="birthPlaceId",column="birth_place"),
            @Result(property="workPlaceId",column="work_place")
    })
    List<PersonPO> getAll();

    @Select("SELECT * FROM person WHERE id = #{id} LIMIT 1")
    @ResultMap("person")
    PersonPO getOneById(long id);

    @Insert("INSERT INTO person(" +
            "name, portrait, gender, party_id, ethnicity_id, " +
            "birth_date, death_date, work_date, retire_date, party_date, " +
            "ancestral_home, birth_place, work_place, " +
            "university, major, education, degree, " +
            "ranking, profile_id, is_enabled, create_time, update_time) " +
            "VALUES(" +
            "#{name}, #{portrait}, #{gender}, #{partyId}, #{ethnicityId}, " +
            "#{birthDate}, #{deathDate}, #{workDate}, #{retireDate}, #{partyDate}, " +
            "#{ancestralHomeId}, #{birthPlaceId}, #{workPlaceId}," +
            "#{university}, #{major}, #{education}, #{degree}," +
            "#{ranking}, #{profileId}, #{enabled}, #{createTime}, #{updateTime})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insertOne(PersonPO person);

    // TODO: 存在设置某个属性为null不成功的情况
    @Update("<script> " +
            "UPDATE person" +
            "<trim prefix='set' suffixOverrides=',' suffix=' WHERE id = #{id}'>" +
            "<if test='name != null'> name=#{name}, </if>" +
            "<if test='portrait != null'> portrait=#{portrait}, </if>" +
            "<if test='gender != null'> gender=#{gender}, </if>" +
            "<if test='ethnicityId != null'> ethnicity_id=#{ethnicityId}, </if>" +
            "<if test='partyId != null'> party_id=#{partyId}, </if>" +
            "<if test='birthDate != null'> birth_date=#{birthDate}, </if>" +
            "<if test='deathDate != null'> death_date=#{deathDate}, </if>" +
            "<if test='workDate != null'> work_date=#{workDate}, </if>" +
            "<if test='partyDate != null'> party_date=#{partyDate}, </if>" +
            "<if test='retireDate != null'> retire_date=#{retireDate}, </if>" +
            "<if test='ancestralHomeId != null'> ancestral_home=#{ancestralHomeId}, </if>" +
            "<if test='birthPlaceId != null'> birth_place=#{birthPlaceId}, </if>" +
            "<if test='workPlaceId != null'> work_place=#{workPlaceId}, </if>" +
            "<if test='university != null'> university=#{university}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='education != null'> education=#{education}, </if>" +
            "<if test='major != null'> major=#{major}, </if>" +
            "<if test='degree != null'> degree=#{degree}, </if>" +
            "<if test='ranking != null'> ranking=#{ranking}, </if>" +
            "<if test='profileId != null'> profile_id=#{profileId}, </if>" +
            "<if test='createTime != null'> create_time=#{createTime}, </if>" +
            "<if test='updateTime != null'> update_time=#{updateTime}, </if>" +
            "<if test='enabled != null'> is_enabled=#{enabled}, </if>" +
            "<if test='deleted != null'> is_deleted=#{deleted}, </if>" +
            "</trim>" +
            "</script>")
    int updateOne(PersonPO person);

    @Update("UPDATE person SET is_deleted = true WHERE id = #{id}")
    int deleteOne(long id);

    @Delete("Delete FROM person WHERE id = #{id}")
    int realDeleteOne(long id);
}
