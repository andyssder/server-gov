package com.politics.chn.repo.dao;

import com.politics.chn.domain.user.Entity.UserInfoDO;
import com.politics.chn.repo.dao.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @create 2021-03-31 22:31
 */
@Repository
public class UserInfoDao {
    private UserInfoMapper userInfoMapper;

    @Autowired
    public void setUserInfoMapper(UserInfoMapper userInfoMapper) {
        this.userInfoMapper = userInfoMapper;
    }

    public UserInfoDO getOneByField(String field, String value) {
        return userInfoMapper.getOneById(field, value);
    }
}
