package com.politics.chn.repo.official.po;

import lombok.Data;

import java.util.Date;
import java.util.Objects;

/**
 * @author andyssder
 * @since 2021-04-27
 */
@Data
public class PersonPO {
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

    Boolean enabled;
    Boolean deleted;

    Date createTime;
    Date updateTime;

}
