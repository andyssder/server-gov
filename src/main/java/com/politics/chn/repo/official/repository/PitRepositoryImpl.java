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
import java.util.Collections;
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
        } else if (Objects.nonNull(query.getDistrictId())) {
            return getByDistrictId(query.getDistrictId());
        } else {
            return getAll();
        }
    }

    private List<Pit> getAll() {
        List<PitPO> list = pitDao.getAll();
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    private List<Pit> getByDistrictId(int districtId) {
        List<PitPO> list = pitDao.getByDistrictId(districtId);
        return list.stream().map(item -> BeanUtil.toBean(item, Pit.class)).collect(Collectors.toList());
    }

    private List<Pit> getChildren(long pid) {
        List<PitPO> list =  pitDao.getChildren(pid);
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
        return true;
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
        long pid = pit.getPid();
        List<Pit> list = new ArrayList<>();
        list.add(pit);
        while (pid != 0) {
            Pit parent = find(pid);
            list.add(parent);
            pid = parent.getPid();
        }
        Collections.reverse(list);
        return list;
    }

    @Override
    public Long countChildren(Long pid) {
        return pitDao.countChildren(pid);
    }
}
