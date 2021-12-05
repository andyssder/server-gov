package com.politics.chn.repo.user.dao;

import com.politics.chn.repo.user.dao.mapper.UserMapper;
import com.politics.chn.repo.user.po.UserPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @since 2021-03-31
 * @author xu
 */
@Repository
public class UserDao {
    private UserMapper userMapper;

    @Autowired
    public void setBaseUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public UserPO getOneByField(String field, String value) {
        return userMapper.getOneByField(field, value);
    }

    public boolean insertOne(UserPO baseUser) {
        return userMapper.insertOne(baseUser) > 0;
    }

    public List<UserPO> getAll() {
        return userMapper.getAll();
    }

}
