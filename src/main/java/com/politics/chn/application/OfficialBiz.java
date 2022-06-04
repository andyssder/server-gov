package com.politics.chn.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.application.dto.OfficialDTO;
import com.politics.chn.application.dto.ProfileDTO;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.*;
import com.politics.chn.service.official.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Service
public class OfficialBiz {

    @Autowired
    private OfficialService officialService;

    @Autowired
    private PartyService partyService;

    @Autowired
    private EthnicityService ethnicityService;

    @Autowired
    private DistrictService districtService;

    @Autowired
    private CarrotService carrotService;

    @Autowired
    private PitService pitService;

    public List<OfficialDTO> getOfficialList() {
        List<Official> officials =  officialService.getAllOfficial();

        return officials.stream().map(this::transfer).collect(Collectors.toList());
    }

    public OfficialDTO getOneOfficial(long id) {
        Official official = officialService.getOfficialById(id);
        Assert.notNull(official, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
        return transfer(official);
    }

    public void addOfficial(OfficialDTO officialDTO) {
        Person person = BeanUtil.toBean(officialDTO, Person.class);
        List<Profile> profiles = officialDTO.getProfiles().stream().map(item -> BeanUtil.toBean(item, Profile.class)).collect(Collectors.toList());

        Official official = new Official(person, profiles);

        Assert.isTrue(official.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(officialService.addOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void updateOfficial(OfficialDTO officialDTO) {
        Person person = BeanUtil.toBean(officialDTO, Person.class);
        List<Profile> profiles = officialDTO.getProfiles().stream().map(item -> BeanUtil.toBean(item, Profile.class)).collect(Collectors.toList());

        Official official = new Official(person, profiles);
        Assert.isTrue(officialService.updateOfficial(official), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    public void deleteOfficial(long id) {
        Assert.isTrue(officialService.deleteOfficial(id), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
    }

    private OfficialDTO transfer(Official official) {
        if (Objects.isNull(official)) {
            return null;
        }
        OfficialDTO officialDTO = BeanUtil.toBean(official.getPerson(), OfficialDTO.class);
        officialDTO.setPartyName(partyService.getPartyShowNameById(officialDTO.getPartyId()));
        officialDTO.setEthnicityName(ethnicityService.getEthnicityNameById(officialDTO.getPartyId()));
        List<District> districts = districtService.getFullPath(officialDTO.getAncestralHomeId());
        officialDTO.setAncestralHomeName(districts.stream().map(District::getName).collect(Collectors.joining()));
        officialDTO.setAncestralHomePath(districts.stream().map(District::getId).collect(Collectors.toList()));

        districts = districtService.getFullPath(officialDTO.getBirthPlaceId());
        officialDTO.setBirthPlaceName(districts.stream().map(District::getName).collect(Collectors.joining()));
        officialDTO.setBirthPlacePath(districts.stream().map(District::getId).collect(Collectors.toList()));

        districts = districtService.getFullPath(officialDTO.getWorkPlaceId());
        officialDTO.setWorkPlaceName(districts.stream().map(District::getName).collect(Collectors.joining()));
        officialDTO.setWorkPlacePath(districts.stream().map(District::getId).collect(Collectors.toList()));

        if (CollectionUtil.isNotEmpty(official.getProfiles())) {
            List<ProfileDTO> profileDTOS = new ArrayList<>();
            official.getProfiles().forEach(item -> {
                ProfileDTO profileDTO = BeanUtil.toBean(item, ProfileDTO.class);
                List<District> profileDistricts = districtService.getFullPath(item.getDistrict());
                profileDTO.setDistrictName(profileDistricts.stream().map(District::getName).collect(Collectors.joining()));
                profileDTO.setDistrictPath(profileDistricts.stream().map(District::getId).collect(Collectors.toList()));

                List<Pit> pits = pitService.getFullPath(item.getPit());
                profileDTO.setPitName(pits.stream().map(pit -> StringUtils.emptyToDefault(pit.getShortName(), pit.getName())).collect(Collectors.joining()));
                profileDTO.setPitPath(pits.stream().map(Pit::getId).collect(Collectors.toList()));

                profileDTO.setCarrotName(carrotService.getCarrotShowNameById(item.getCarrot()));
                profileDTOS.add(profileDTO);
            });
            officialDTO.setProfiles(profileDTOS);
        }

        return officialDTO;
    }
}


