package com.politics.chn.service.official;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.common.utils.StringUtils;
import com.politics.chn.domain.official.entity.Party;
import com.politics.chn.domain.official.query.PartyQuery;
import com.politics.chn.domain.official.repository.PartyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Objects;

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
        return partyRepository.query(new PartyQuery());
    }

    public String getPartyShowNameById(Integer id) {
        Assert.notNull(id, ()-> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        Party party = partyRepository.find(id.longValue());
        if (Objects.isNull(party)) {
            return "";
        }
        return StringUtils.emptyToDefault(party.getShortName(), party.getName());
    }
}
