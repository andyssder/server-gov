package com.politics.chn.domain.common;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author xu
 * @since 2021-12-02
 */
public interface Repository<T extends Entity, Q extends Query<T>> {

    // TODO ID处理
    T find(@NotNull Long id);

    List<T> query(@NotNull Q query);

    boolean remove(@NotNull Long id);

    boolean save(@NotNull T aggregate);
}
