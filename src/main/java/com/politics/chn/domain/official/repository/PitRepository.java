package com.politics.chn.domain.official.repository;


import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.PitQuery;

import java.util.List;

/**
 * @author andyssder
 * @since 2021-12-02
 */
public interface PitRepository extends Repository<Pit, PitQuery> {

    List<Pit> queryFullPath(Long id);

    Long countChildren(Long id);
}
