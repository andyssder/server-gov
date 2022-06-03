package com.politics.chn.service.official;

import com.politics.chn.common.enums.biz.PitTypeEnum;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
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
        } else if ("district".equals(type)) {
            // TODO: 校验
            query.setDistrictId(value.intValue());
        } else if(StringUtils.isNotBlank(type)){
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        }
        return pitRepository.query(query);
    }

    public List<Pit> getFullPath(Long id) {
        Assert.notNull(id, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        return pitRepository.queryFullPath(id);
    }

}
