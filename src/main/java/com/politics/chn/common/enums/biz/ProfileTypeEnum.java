package com.politics.chn.common.enums.biz;

import lombok.Getter;

/**
 * @author andyssder
 * @since 2022-06-04
 */
@Getter
public enum ProfileTypeEnum {

    /**
     * 普通简历
     */
    NORMAL(0),

    /**
     * 聚合简历根节点
     */
    AGGREGATE_ROOT(1),

    /**
     * 聚合简历子节点
     */
    AGGREGATE_LEAF(2),
    ;
    private final Integer type;

    ProfileTypeEnum(Integer type) {
        this.type = type;
    }
}
