package com.politics.chn.repo.official.po;

import lombok.Data;


/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class CarrotPO {
    Long id;
    String name;
    String shortName;

    Long pitId;

    Integer ranking;
    Long sort;

    Boolean enabled;
    Boolean deleted;

}
