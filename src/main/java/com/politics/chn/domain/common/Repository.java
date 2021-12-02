package com.politics.chn.domain.common;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xu
 * @since 2021-12-02
 */
public interface Repository<T, Q extends Query> {

    // TODO ID处理
    T find(@NotNull Long id);

    List<T> query(@NotNull Q query);

    boolean remove(@NotNull Long id);

    boolean save(@NotNull T aggregate);
}
