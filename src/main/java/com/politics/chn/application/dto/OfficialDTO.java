package com.politics.chn.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author andyssder
 * @since 2022-05-28
 */
@Data
public class OfficialDTO {

    Long id;
    String name;
    String portrait;
    Integer gender;

    Integer partyId;
    String partyName;

    Integer ethnicityId;
    String ethnicityName;

    Date birthDate;
    Date deathDate;
    Date workDate;
    Date retireDate;
    Date partyDate;

    Integer ancestralHomeId;
    String ancestralHomeName;
    List<Integer> ancestralHomePath;

    Integer birthPlaceId;
    String birthPlaceName;
    List<Integer> birthPlacePath;

    Integer workPlaceId;
    String workPlaceName;
    List<Integer> workPlacePath;

    String university;
    String major;
    String education;
    String degree;

    Integer ranking;
    String rankingName;

    Long profileId;
    String profileName;

    Date createTime;
    Date updateTime;

    Boolean enabled;

    List<ProfileDTO> profiles;

}
