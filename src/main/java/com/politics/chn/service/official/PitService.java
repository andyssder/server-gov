package com.politics.chn.service.official;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.PitQuery;
import com.politics.chn.domain.official.repository.PitRepository;
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

    public Long addPit(Pit pit) {

        // TODO: 优化常量和if代码
        Assert.isTrue(pit.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        int lft, rgt, level;
        PitQuery query = new PitQuery();
        query.setPid(pit.getPid());
        List<Pit> brotherPit = pitRepository.query(query);
        if (brotherPit.size() > 0) {
            Pit lastPit = brotherPit.get(brotherPit.size() - 1);
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
            Pit parentPit = pitRepository.find(query.getPid());
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
        Assert.isTrue(pitRepository.save(pit), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });
        return pit.getId();
    }

    public void updatePit(Pit pit) {
        Assert.notNull(pit.getId(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        Assert.isTrue(pitRepository.save(pit), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public void deletePit(long id) {
        Assert.isTrue(pitRepository.remove(id), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
    }

    public List<Pit> getPitList(String type, Long value) {
        Assert.isTrue(type == null || value != null, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        PitQuery query = new PitQuery();
        if ("pid".equals(type)) {
            query.setPid(value);
        } else if ("level".equals(type)) {
            // TODO: 校验
            query.setLevel(value.intValue());
        } else if ("district".equals(type)) {
            // TODO: 校验
            query.setDistrictLevel(value.intValue());
        } else if(StringUtils.isNotBlank(type)){
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        }
        return pitRepository.query(query);
    }
}
