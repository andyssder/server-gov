package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.Data;


/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class Pit implements Entity {

    Long id;
    String name;
    String shortName;


    Long pid;
    Integer level;

    /**
     * 机构类型
     */
    Integer type;

    /**
     * 机构级别
     */
    Integer ranking;

    /**
     * 所属地区级别
     */
    Integer districtLevel;

    /**
     * 所属地区
     */
    Integer districtId;

    Long sort;

    Boolean enabled;
}
