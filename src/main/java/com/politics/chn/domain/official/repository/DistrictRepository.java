package com.politics.chn.domain.official.repository;

import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.query.DistrictQuery;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author andyssder
 * @since 2021-12-02
 */
public interface DistrictRepository extends Repository<District, DistrictQuery> {

    List<District> queryFullPath(Integer id);
}
