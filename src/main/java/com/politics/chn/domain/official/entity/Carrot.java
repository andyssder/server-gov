package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.Data;


/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class Carrot implements Entity {
    Long id;
    String name;
    String shortName;

    Long pitId;

    Integer ranking;
    Long sort;

    Boolean enabled;

}
