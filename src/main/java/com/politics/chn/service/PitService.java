package com.politics.chn.service;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.value.PitDO;
import com.politics.chn.repo.repository.PitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @since 2021-02-16
 * @author andyssder
 */
@Service
public class PitService {

    private PitRepository pitRepository;

    @Autowired
    private void setPitRepository(PitRepository pitRepository) {
        this.pitRepository = pitRepository;
    }

    public Long addPit(PitDO pit) {
        // TODO: 优化常量和if代码
        Assert.isTrue(pit.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        int lft, rgt, level;
        long pid = pit.getPid();
        List<PitDO> brotherPit = pitRepository.getChildren(pid);
        if (brotherPit.size() > 0) {
            PitDO lastPit = brotherPit.get(brotherPit.size() - 1);
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
            PitDO parentPit = pitRepository.getOneById(pid);
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
        pit.setLevel(level);
        pit.setLft(lft);
        pit.setRgt(rgt);
        Assert.isTrue(pitRepository.insertOne(pit), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return pit.getId();
    }

    public void updatePit(PitDO pit) {
        Assert.notNull(pit.getId(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Assert.isTrue(pitRepository.updateOne(pit), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void deletePit(long id) {
        Assert.isTrue(pitRepository.deleteOne(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<PitDO> getPitList(String type, Long value) {
        Assert.isTrue(type == null || value != null, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        if ("pid".equals(type)) {
            return pitRepository.getChildren(value);
        } else if ("level".equals(type)) {
            // TODO: 校验
            return pitRepository.getPitListByLevel(value.intValue());
        } else if ("district".equals(type)) {
            // TODO: 校验
            return pitRepository.getByDistrictLevel(value.intValue());
        } else if(type == null || type.isEmpty()){
            return pitRepository.getAll();
        } else {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        }
    }
}
