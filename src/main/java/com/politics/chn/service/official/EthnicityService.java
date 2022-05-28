package com.politics.chn.service.official;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.Ethnicity;
import com.politics.chn.domain.official.query.EthnicityQuery;
import com.politics.chn.domain.official.repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

/**
 * @author andyssder
 * @since 2021-11-28
 */
@Service
public class EthnicityService {
    private EthnicityRepository ethnicityRepository;

    @Autowired
    public void setEthnicityRepository(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }

    public List<Ethnicity> getEthnicityList() {
        return ethnicityRepository.query(new EthnicityQuery());
    }

    public String getEthnicityNameById(Integer id) {
        Assert.notNull(id, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Ethnicity ethnicity = ethnicityRepository.find(id.longValue());
        return Objects.isNull(ethnicity) ? "" : ethnicity.getName();
    }

}
