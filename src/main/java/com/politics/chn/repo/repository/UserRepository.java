package com.politics.chn.repo.repository;

import com.politics.chn.domain.user.Entity.UserInfoDO;
import com.politics.chn.domain.user.UserDO;
import org.springframework.stereotype.Repository;

/**
 * @author xu
 * @create 2021-03-31 22:30
 */
@Repository
public class UserRepository {

    public UserDO getUserByUsername(String username) {
        UserDO userDO = new UserDO();
        UserInfoDO userInfoDO = new UserInfoDO();
        userInfoDO.setUsername("admin");
        userInfoDO.setPassword("123");
        userDO.setUserInfoDO(userInfoDO);
        return userDO;
    }
}
