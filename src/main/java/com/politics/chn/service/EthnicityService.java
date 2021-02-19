package com.politics.chn.service;

import com.politics.chn.repo.dao.EthnicityDao;
import com.politics.chn.repo.repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author andyssder
 * @create 2021-02-20 14:47
 */
@Service
public class EthnicityService {
    private EthnicityRepository ethnicityRepository;

    @Autowired
    private void setEthnicityRepository(EthnicityRepository ethnicityRepository) {
        this.ethnicityRepository = ethnicityRepository;
    }
}
