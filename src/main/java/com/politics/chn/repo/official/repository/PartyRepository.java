package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.PartyDO;
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
public class PartyRepository {
    private PartyDao partyDao;

    @Autowired
    private void setPartyDao(PartyDao partyDao) {
        this.partyDao = partyDao;
    }

    public List<PartyDO> getPartyList() {
        List<PartyPO> list = partyDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, PartyDO.class)).collect(Collectors.toList());
    }

    public PartyDO getOneById(int id) {
        PartyPO partyPO = partyDao.getOneById(id);
        return BeanUtil.toBean(partyPO, PartyDO.class);
    }
}
