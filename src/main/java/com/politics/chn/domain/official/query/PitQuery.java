package com.politics.chn.domain.official.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.official.entity.Pit;
import lombok.Data;

/**
 * @author andyssder
 * @since 2021-12-02
 */
@Data
public class PitQuery implements Query<Pit> {
    Long pid;
    Integer districtId;

}
