package com.politics.chn.common.enums.biz;

import com.politics.chn.application.dto.CommonEnumDTO;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Getter
public enum RankingEnum {

    DEFAULT(0, "默认"),

    BIG_BROTHER(1, "正国级"),
    SUB_NATIONAL_LEADER(2, "副国级"),

    MINISTERIAL(3, "正部级"),
    SUB_MINISTERIAL(4, "副部级"),

    BUREAU_DIRECTOR(5, "正厅级"),
    DEPUTY_BUREAU_DIRECTOR(6, "副厅级"),

    DIVISION_HEAD(7, "正处级"),
    DEPUTY_DIVISION_HEAD(8, "副处级"),

    SECTION_HEAD(9, "正科级"),
    DEPUTY_SECTION_HEAD(10, "副科级"),

    STAFF_MEMBER(11, "科员"),
    CLERK(12, "办事员"),

    OTHER(13, "其他")
    ;

    private final Integer ranking;

    private final String desc;

    RankingEnum(Integer ranking, String desc) {
        this.ranking = ranking;
        this.desc = desc;
    }

    public CommonEnumDTO format() {
        return new CommonEnumDTO(this.ranking, this.desc);
    }

    public static List<CommonEnumDTO> getAll() {
        return Arrays.stream(RankingEnum.values()).map(RankingEnum::format).collect(Collectors.toList());
    }

    public static String getDescByRanking(Integer ranking) {
        for (RankingEnum rankingEnum: RankingEnum.values()) {
            if (rankingEnum.ranking.equals(ranking)) {
                return rankingEnum.desc;
            }
        }
        return "";
    }

}
