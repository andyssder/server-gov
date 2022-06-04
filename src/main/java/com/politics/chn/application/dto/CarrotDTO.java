package com.politics.chn.application.dto;

import lombok.Data;

import java.util.List;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Data
public class CarrotDTO {
    Long id;
    String name;
    String shortName;

    Long pitId;
    List<Long> pitPath;
    String pitName;

    Integer ranking;
    String rankingDesc;

    Long sort;

    Boolean enabled;
}
