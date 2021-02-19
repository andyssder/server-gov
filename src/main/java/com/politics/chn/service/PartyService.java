package com.politics.chn.service;

import com.politics.chn.repo.repository.EthnicityRepository;
import com.politics.chn.repo.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author andyssder
 * @create 2021-02-20 14:47
 */
@Service
public class PartyService {
    private PartyRepository partyRepository;

    @Autowired
    private void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }
}
