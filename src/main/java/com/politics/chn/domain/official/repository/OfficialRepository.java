package com.politics.chn.domain.official.repository;

import com.politics.chn.domain.common.Repository;
import com.politics.chn.domain.official.entity.Official;
import com.politics.chn.domain.official.query.OfficialQuery;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xu
 * @since 2021-12-05
 */
public interface OfficialRepository extends Repository<Official, OfficialQuery> {
    List<Official> queryPerson(@NotNull OfficialQuery query);

}
