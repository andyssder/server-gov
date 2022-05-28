package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.official.entity.District;
import com.politics.chn.domain.official.query.DistrictQuery;
import com.politics.chn.domain.official.repository.DistrictRepository;
import com.politics.chn.repo.official.dao.DistrictDao;
import com.politics.chn.repo.official.po.DistrictPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @since 2021-02-06 16:45
 * @author andyssder
 */
@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

    private DistrictDao districtDao;

    @Autowired
    private void setDistrictDao(DistrictDao districtDao) {
        this.districtDao = districtDao;
    }

    @Override
    public District find(Long id) {
        DistrictPO districtPO = districtDao.getOneById(id.intValue());
        return BeanUtil.toBean(districtPO, District.class);
    }

    @Override
    public List<District> query(DistrictQuery query) {
        List<DistrictPO> districtPOS;
        if (Objects.nonNull(query.getPid())) {
            District district = find(query.getPid().longValue());
            districtPOS = Objects.isNull(district) ? new ArrayList<>() : districtDao.getChildren(district.getLft(), district.getRgt(), district.getLevel());
        } else if (Objects.nonNull(query.getLevel())) {
            districtPOS = districtDao.getByLevel(query.getLevel());
        }  else {
            districtPOS = new ArrayList<>();
        }
        return districtPOS.stream().map((item) -> BeanUtil.toBean(item, District.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(District aggregate) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public List<District> queryFullPath(Integer id) {
        District district = find(id.longValue());
        if (Objects.isNull(district)) {
            return new ArrayList<>();
        }
        List<DistrictPO> parents = districtDao.getParent(district.getLft(), district.getRgt());

        List<District> list = parents.stream().map((item) -> BeanUtil.toBean(item, District.class)).collect(Collectors.toList());

        list.add(district);
        return list;
    }
}
