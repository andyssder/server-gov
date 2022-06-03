package com.politics.chn.common.enums.biz;

import java.util.Arrays;
import java.util.List;

/**
 * 萝卜坑类型枚举
 * @author andyssder
 * @since 2022-06-03
 */
public enum PitTypeEnum {
    DEFAULT(0, "默认"),

    CPC(10,"党"),

    NPC(20, "人大"),

    GOV(30, "政府"),

    CPPCC(40, "政协"),

    CMC(50, "军队"),

    NSC(60, "监委"),

    SPC(70, "法院"),

    SPP(80, "检察院"),

    OTHER_PARTY(90, "民主党派"),

    SOCIAL_COMMISSION(100, "社会团体"),

    PROVINCE(110, "国企"),

    MUNICIPALITY(120, "高校"),

    BINGTUAN(130, "兵团"),

    ;
    private final Integer type;

    private final String desc;

    PitTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public static List<PitTypeEnum> getAll() {
        return Arrays.asList(PitTypeEnum.values());
    }

}
