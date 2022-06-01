package com.politics.chn.repo.official.po;

import lombok.Data;

import java.util.List;
import java.util.Objects;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class PitPO {
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

    Boolean deleted;


}
