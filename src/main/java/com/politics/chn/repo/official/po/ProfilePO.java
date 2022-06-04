package com.politics.chn.repo.official.po;

import lombok.Data;

import java.util.Date;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class ProfilePO {
    Long id;

    Date startTime;
    Date endTime;
    Long personId;
    Integer districtId;
    Long pitId;
    Long carrotId;
    String remark;
    String summary;
    Integer priority;
    Long pid;
    Integer type;
    Integer ranking;

    Boolean enabled;
    Boolean deleted;

}

