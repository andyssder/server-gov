package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.Party;
import com.politics.chn.domain.official.query.PartyQuery;
import com.politics.chn.domain.official.repository.PartyRepository;
import com.politics.chn.repo.official.dao.PartyDao;
import com.politics.chn.repo.official.po.PartyPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xu
 * @since 2021-11-28
 */
@Repository
public class PartyRepositoryImpl implements PartyRepository {
    private PartyDao partyDao;

    @Autowired
    private void setPartyDao(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    @Override
    public Party find(Long id) {
        PartyPO partyPO = partyDao.getOneById(id.intValue());
        return BeanUtil.toBean(partyPO, Party.class);
    }

    @Override
    public List<Party> query(PartyQuery query) {List<PartyPO> list = partyDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, Party.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(Party aggregate) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }
}
