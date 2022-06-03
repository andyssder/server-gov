package com.politics.chn.common.enums.biz;

import com.politics.chn.application.dto.CommonEnumDTO;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-03
 */
public enum DistrictTypeEnum {

    DEFAULT(0, "默认"),

    PROVINCE(1, "省"),

    AUTONOMOUS_REGION(2, "自治区"),

    MUNICIPALITY(3, "直辖市"),

    SPECIAL_ADMINISTRATIVE_REGION(4, "特别行政区"),

    SUB_PROVINCIAL_CITY(5, "副部级城市"),

    PREFECTURE_LEVEL_CITY(6, "地级市"),

    PREFECTURE(7, "地区"),

    AUTONOMOUS_PREFECTURE(8, "自治州"),

    LEAGUE(9, "盟"),

    MUNICIPALITY_DISTRICT(10, "直辖市下辖区"),

    SUB_PROVINCIAL_DISTRICT(11, "副部级城市下辖区"),

    DISTRICT(12, "市辖区"),

    COUNTY_LEVEL_CITY(13, "县级市"),

    COUNTY(14, "县"),

    AUTONOMOUS_COUNTY(15, "自治县"),

    BANNER(16, "旗"),

    AUTONOMOUS_BANNER(17, "自治旗"),

    SPECIAL_DISTRICT(18, "特区"),

    FORESTRY_AREA(19, "林区"),
    ;
    private final Integer type;

    private final String desc;

    DistrictTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public CommonEnumDTO format() {
        return new CommonEnumDTO(this.type, this.desc);
    }

    public static List<CommonEnumDTO> getAll() {
        return Arrays.stream(DistrictTypeEnum.values()).map(DistrictTypeEnum::format).collect(Collectors.toList());
    }

    public static String getDescByType(Integer type) {
        for (DistrictTypeEnum districtTypeEnum: DistrictTypeEnum.values()) {
            if (districtTypeEnum.type.equals(type)) {
                return districtTypeEnum.desc;
            }
        }
        return "";
    }
}
