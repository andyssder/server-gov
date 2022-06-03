package com.politics.chn.common.enums.biz;

import com.politics.chn.application.dto.CommonEnumDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 萝卜坑类型枚举
 * @author andyssder
 * @since 2022-06-03
 */
public enum PitTypeEnum {
    DEFAULT(0, "默认"),

    CPC(10,"党"),

    NPC(20, "人大"),

    PRESIDENT(30, "国家主席"),

    GOV(40, "政府"),

    CPPCC(50, "政协"),

    CMC(60, "军队"),

    NSC(70, "监委"),

    SPC(80, "法院"),

    SPP(90, "检察院"),

    OTHER_PARTY(100, "民主党派"),

    SOCIAL_COMMISSION(110, "社会团体"),

    PROVINCE(120, "国企"),

    MUNICIPALITY(130, "高校"),

    BINGTUAN(140, "兵团"),

    ;
    private final Integer type;

    private final String desc;

    PitTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public CommonEnumDTO format() {
        return new CommonEnumDTO(this.type, this.desc);
    }

    public static List<CommonEnumDTO> getAll() {
        return Arrays.stream(PitTypeEnum.values()).map(PitTypeEnum::format).collect(Collectors.toList());
    }

    public static String getDescByType(Integer type) {
        for (PitTypeEnum pitTypeEnum: PitTypeEnum.values()) {
            if (pitTypeEnum.type.equals(type)) {
                return pitTypeEnum.desc;
            }
        }
        return "";
    }
}
