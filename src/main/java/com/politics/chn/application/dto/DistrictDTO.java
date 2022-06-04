package com.politics.chn.application.dto;

import lombok.Data;

/**
 * @author andyssder
 * @since 2022-06-04
 */
@Data
public class DistrictDTO {

    Integer id;
    String name;
    Integer code;
    Integer level;
    Integer pid;
    Integer type;
    String typeName;
    Integer ranking;
    String rankingName;

    Boolean hasChildren;
}
