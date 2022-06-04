package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.Data;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class District implements Entity {
    Integer id;
    String name;
    Integer code;
    Integer level;
    Integer lft;
    Integer rgt;
    Integer pid;
    Integer type;
    Integer ranking;
}
