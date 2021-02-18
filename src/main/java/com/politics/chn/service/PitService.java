package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.model.dto.PitDTO;
import com.politics.chn.model.po.PitPO;
import com.politics.chn.repo.repository.PitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author: andyssder
 * @create: 2021-02-16 15:45
 */
@Service
public class PitService {

    private PitRepository pitRepository;

    @Autowired
    private void setPitRepository(PitRepository pitRepository) {
        this.pitRepository = pitRepository;
    }

    public Long addPit(Map<String, Object> addParams) {
        // TODO: 优化常量和if代码
        boolean paramsCheck = addParams.containsKey("pid")
                && addParams.containsKey("name")
                && addParams.containsKey("districtLevel")
                && addParams.containsKey("rank");
        Assert.isTrue(paramsCheck, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        String name = (String) addParams.get("name");
        String shortName = (String) addParams.get("shortName");
        int districtLevel = (int) addParams.get("districtLevel");
        int rank = (int) addParams.get("rank");
        int lft, rgt, level;
        long pid = (long) addParams.get("pid");
        List<PitPO> brotherPit = pitRepository.getChildren(pid);
        if (brotherPit.size() > 0) {
            PitPO lastPit = brotherPit.get(brotherPit.size() - 1);
            level = lastPit.getLevel();
            lft = lastPit.getRgt() + 1;
            if(level == 1) {
                rgt = lft + 1000;
            } else if (level == 2) {
                rgt = lft + 100;
            } else {
                rgt = lft + 1;
            }
        } else {
            PitPO parentPit = pitRepository.getOneById(pid);
            Assert.notNull(parentPit, () -> {
                throw new CommonException(ResultStatusEnum.NOT_FOUND);
            });
            level = parentPit.getLevel() + 1;
            lft = parentPit.getLft() + 1;
            if (level == 1) {
                rgt = lft + 1000;
            } else if (level == 2) {
                rgt = lft + 100;
            } else {
                rgt = lft + 1;
            }
        }
        PitPO newPit = new PitPO(pid, name, shortName, level, rank, districtLevel, lft, rgt);
        Assert.isTrue(pitRepository.insertOne(newPit), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return newPit.getId();
    }

    public void updatePit(long id, Map<String, Object> updateParams) {
        Assert.isTrue(pitRepository.updateOne(id, updateParams), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void deletePit(long id) {
        Assert.isTrue(pitRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<PitDTO> getPitList(Long id, Integer districtLevel) {
        Assert.isTrue(!(id != null && districtLevel != null), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        List<PitPO> tempResult = new ArrayList<>();
        if (id != null) {
            tempResult = pitRepository.getChildren(id);
        } else if (districtLevel != null) {
            tempResult = pitRepository.getByDistrictLevel(districtLevel);
        } else {
            tempResult = pitRepository.getAll();
        }
        return convertPOList2DTOList(tempResult);
    }

    private List<PitDTO> convertPOList2DTOList(List<PitPO> pitPOList) {
        List<PitDTO> result = new ArrayList<>();
        pitPOList.forEach(pitPO -> {
            result.add(new PitDTO(pitPO.getId(), pitPO.getPid(), pitPO.getName(), pitPO.getShortName(), pitPO.getRank(), pitPO.getDistrictLevel()));
        });
        return result;
    }
}
