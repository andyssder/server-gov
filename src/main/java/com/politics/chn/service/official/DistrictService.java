package com.politics.chn.service.official;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.value.DistrictDO;
import com.politics.chn.repo.official.po.DistrictPO;
import com.politics.chn.repo.official.repository.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @since 2021-02-06
 * @author andyssder
 */
@Service
public class DistrictService {

    private DistrictRepository districtRepository;

    @Autowired
    private void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<DistrictDO> getProvinces() {
        List<DistrictPO> list = districtRepository.getByLevel(1);
        List<DistrictDO> result = list.stream().map(item -> BeanUtil.toBean(item, DistrictDO.class)).collect(Collectors.toList());
        return result;
    }

    public List<DistrictDO> getCities(Integer parentId) {
        List<DistrictPO> list = districtRepository.getChildrenById(parentId);
        Assert.notNull(list, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });
        List<DistrictDO> result = list.stream().map(item -> BeanUtil.toBean(item, DistrictDO.class)).collect(Collectors.toList());
        return result;
    }
}
