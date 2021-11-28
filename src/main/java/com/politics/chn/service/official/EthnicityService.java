package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.value.EthnicityDO;
import com.politics.chn.domain.official.value.PartyDO;
import com.politics.chn.repo.official.dao.EthnicityDao;
import com.politics.chn.repo.official.po.EthnicityPO;
import com.politics.chn.repo.official.repository.EthnicityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
        List<EthnicityPO> list = ethnicityRepository.getEthnicityList();
        List<EthnicityDO> result = list.stream().map(item -> BeanUtil.toBean(item, EthnicityDO.class)).collect(Collectors.toList());
        return result;
    }


}
