package com.politics.chn.application;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollectionUtil;
import com.politics.chn.application.dto.CarrotDTO;
import com.politics.chn.common.enums.biz.RankingEnum;
import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.Carrot;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.CarrotQuery;
import com.politics.chn.service.official.CarrotService;
import com.politics.chn.service.official.PitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2022-06-03
 */
@Service
public class CarrotBiz {
    @Autowired
    private CarrotService carrotService;

    @Autowired
    private PitService pitService;

    public Long addCarrot(Carrot carrot) {
        return carrotService.addCarrot(carrot);
    }

    public void updateCarrot(Carrot carrot) {
        carrotService.updateCarrot(carrot);
    }

    public List<CarrotDTO> queryCarrot(CarrotQuery carrotQuery) {
        List<Carrot> carrots = carrotService.queryCarrot(carrotQuery);
        return carrots.stream().map(this::transfer).collect(Collectors.toList());
    }

    public void deleteCarrot(long id) {
        carrotService.deleteCarrot(id);
    }

    private CarrotDTO transfer(Carrot carrot) {
        if (Objects.isNull(carrot)) {
            return null;
        }
        CarrotDTO carrotDTO = BeanUtil.toBean(carrot, CarrotDTO.class);
        carrotDTO.setRankingName(RankingEnum.getDescByRanking(carrotDTO.getRanking()));

        List<Pit> pits = pitService.getFullPath(carrotDTO.getPitId());
        carrotDTO.setPitPath(pits.stream().map(Pit::getId).collect(Collectors.toList()));
        if (CollectionUtil.isNotEmpty(pits)) {
            Pit pit = pits.get(pits.size() - 1);
            carrotDTO.setPitName(StringUtils.emptyToDefault(pit.getShortName(), pit.getName()));
        }
        return carrotDTO;
    }
}
