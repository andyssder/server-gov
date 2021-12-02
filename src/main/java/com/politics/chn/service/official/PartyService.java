package com.politics.chn.service.official;

import com.politics.chn.domain.official.entity.PartyDO;
import com.politics.chn.repo.official.repository.PartyRepository;
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

    public List<PartyDO> getPartyList() {
        return partyRepository.getPartyList();
    }


    public PartyDO getPartyById(int id) {
        return partyRepository.getOneById(id);
    }
}
