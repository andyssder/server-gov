package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.value.PartyDO;
import com.politics.chn.repo.official.po.PartyPO;
import com.politics.chn.repo.official.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
