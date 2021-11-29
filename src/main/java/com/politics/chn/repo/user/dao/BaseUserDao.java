package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.dao.mapper.BaseUserMapper;
import com.politics.chn.repo.user.po.BaseUserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-03-31
 * @author xu
 */
@Repository
public class BaseUserDao {
    private BaseUserMapper baseUserMapper;

    @Autowired
    public void setBaseUserMapper(BaseUserMapper baseUserMapper) {
        this.baseUserMapper = baseUserMapper;
    }

    public BaseUserPO getOneByField(String field, String value) {
        return baseUserMapper.getOneByField(field, value);
    }

    public boolean insertOne(BaseUserPO baseUser) {
        return baseUserMapper.insertOne(baseUser) > 0;
    }

    public List<BaseUserPO> getAll() {
        return baseUserMapper.getAll();
    }

}
