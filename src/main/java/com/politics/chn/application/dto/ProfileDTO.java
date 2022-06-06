package com.politics.chn.application.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author andyssder
 * @since 2022-05-28
 */
@Data
public class ProfileDTO {
    Long id;

    Date startTime;
    Date endTime;

    Integer districtId;
    String districtName;
    List<Integer> districtPath;

    Long pitId;
    String pitName;
    List<Long> pitPath;

    Long carrotId;
    String carrotName;

    String remark;
    String summary;
    Integer priority;

    Long pid;
    Integer type;
    Integer ranking;

    Integer sort;
    List<ProfileDTO> subProfiles;
    Boolean hasChildren = false;

    Boolean enabled;

}
