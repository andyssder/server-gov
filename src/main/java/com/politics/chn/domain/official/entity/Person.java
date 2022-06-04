package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class Person implements Entity {
    // TODO 验证参数
    Long id;
    String name;
    String portrait;
    Integer gender;

    Integer partyId;
    Integer ethnicityId;

    Date birthDate;
    Date deathDate;
    Date workDate;
    Date retireDate;
    Date partyDate;

    Integer ancestralHomeId;
    Integer birthPlaceId;
    Integer workPlaceId;

    String university;
    String major;
    String education;
    String degree;

    Integer ranking;
    Long profileId;

    Date createTime;
    Date updateTime;

    Boolean enabled;

}
