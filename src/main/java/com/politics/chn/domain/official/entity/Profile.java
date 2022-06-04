package com.politics.chn.domain.official.entity;

import com.politics.chn.domain.common.Entity;
import lombok.Data;

import java.util.Date;

/**
 * @since 2021-02-19
 * @author andyssder
 */
@Data
public class Profile implements Entity {
    // TODO 验证参数
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

}
