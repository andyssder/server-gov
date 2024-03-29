package com.politics.chn.repo.official.po;

import lombok.Data;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class DistrictPO {
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
