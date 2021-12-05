package com.politics.chn.service.official;

import com.politics.chn.domain.official.entity.Party;
import com.politics.chn.domain.official.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @since 2021-02-20
 * @author andyssder
 */
@Service
public class PartyService {

    private PartyRepository partyRepository;

    @Autowired
    public void setPartyRepository(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }

    public List<Party> getPartyList() {
        return partyRepository.query(null);
    }
}
