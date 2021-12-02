package com.politics.chn.service.official;

import com.politics.chn.domain.official.entity.EthnicityDO;
import com.politics.chn.repo.official.repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author xu
 * @since 2021-11-28
 */
@Service
public class EthnicityService {
    private EthnicityRepository ethnicityRepository;

    @Autowired
    public void setEthnicityRepository(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }

    public List<EthnicityDO> getEthnicityList() {
        return ethnicityRepository.getEthnicityList();
    }

    public EthnicityDO getEthnicityById(int id) {
        return ethnicityRepository.getOneById(id);
    }

}
