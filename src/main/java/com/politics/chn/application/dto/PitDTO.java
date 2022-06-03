package com.politics.chn.application.dto;

import lombok.Data;

import java.util.List;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Data
public class PitDTO {
    Long id;
    String name;
    String shortName;

    Long pid;
    Integer level;

    Integer type;
    String typeDesc;

    Integer ranking;
    String rankingDesc;

    Integer districtLevel;
    Integer districtId;
    String districtName;
    List<Integer> districtPath;

    Long sort;

    Boolean hasChildren;
    Boolean enabled;
}
