package com.politics.chn.repo.official.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.domain.official.entity.Pit;
import com.politics.chn.domain.official.query.PitQuery;
import com.politics.chn.domain.official.repository.PitRepository;
import com.politics.chn.repo.official.dao.PitDao;
import com.politics.chn.repo.official.po.PitPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @since 2021-02-08
 * @author andyssder
 */
@Repository
public class PitRepositoryImpl implements PitRepository {

    private PitDao pitDao;

    @Autowired
    private void setPitDao(PitDao pitDao) {
        this.pitDao = pitDao;
    }

    @Override
    public Pit find(Long id) {
        PitPO pitPO = pitDao.getOneById(id);
        return BeanUtil.toBean(pitPO, Pit.class);
    }

    @Override
    public List<Pit> query(PitQuery query) {
        if (Objects.nonNull(query.getPid())) {
            return getChildren(query.getPid());
        } else if (Objects.nonNull(query.getDistrictLevel())) {
            return getByDistrictLevel(query.getDistrictLevel());
        } else if (Objects.nonNull(query.getLevel())) {
            return getPitListByLevel(query.getLevel());
        } else {
            return getAll();
        }
    }
    private List<Pit> getAll() {
        List<PitPO> list = pitDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    private List<Pit> getByDistrictLevel(int districtLevel) {
        List<PitPO> list = pitDao.getByDistrictLevel(districtLevel);
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    private List<Pit> getPitListByLevel(int level) {
        List<PitPO> list =  pitDao.getByLevel(level);
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    private List<Pit> getChildren(long id) {
        Pit pit = find(id);
        List<PitPO> list =  pitDao.getChildren(pit.getLft(), pit.getRgt(), pit.getLevel());
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        return pitDao.deleteOne(id);
    }

    @Override
    public boolean save(Pit pit) {
        if (Objects.isNull(pit.getId())) {
            return insertOne(pit);
        } else {
            return updateOne(pit);
        }
    }

    private Boolean insertOne(Pit pit) {
        PitPO pitPO = BeanUtil.toBean(pit, PitPO.class);
        if (!pitDao.insertOne(pitPO)) {
            return false;
        }
        pit.setId(pitPO.getId());
        return pitDao.insertOne(pitPO);
    }

    private Boolean updateOne(Pit pit) {
        PitPO pitPO = BeanUtil.toBean(pit, PitPO.class);
        return pitDao.updateOne(pitPO);
    }

    @Override
    public List<Pit> queryFullPath(Long id) {
        Pit pit = find(id);
        if (Objects.isNull(pit)) {
            return new ArrayList<>();
        }
        List<PitPO> parents = pitDao.getParent(pit.getLft(), pit.getRgt());

        List<Pit> list = parents.stream().map((item) -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());

        list.add(pit);
        return list;
    }
}
