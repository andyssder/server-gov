package com.politics.chn.service;

import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.domain.official.value.PartyDO;
import com.politics.chn.repo.repository.CommonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author andyssder
 * @create 2021-02-20 16:32
 */
@Service
public class CommonService {
    private CommonRepository commonRepository;

    @Autowired
    private void setCommonRepository(CommonRepository commonRepository) {
        this.commonRepository = commonRepository;
    }

    public List<EthnicityDO> getEthnicityList() {
        return commonRepository.getEthnicityList();
    }

    public List<PartyDO> getPartyList() {
        return commonRepository.getPartyList();
    }
}
