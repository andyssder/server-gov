package com.politics.chn.repo.user.repository;

import cn.hutool.core.bean.BeanUtil;
import com.politics.chn.common.enums.sys.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.domain.user.entity.User;
import com.politics.chn.domain.user.query.UserQuery;
import com.politics.chn.domain.user.repository.UserRepository;
import com.politics.chn.repo.user.dao.UserDao;
import com.politics.chn.repo.user.dao.UserRoleRelationDao;
import com.politics.chn.repo.user.po.UserPO;
import com.politics.chn.repo.user.po.UserRoleRelationPO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author andyssder
 * @since 2021-11-28
 */
@Repository
public class UserRepositoryImpl implements UserRepository {
    private UserDao userDao;

    // TODO 如何处理relation
    private UserRoleRelationDao userRoleRelationDao;

    @Autowired
    public void setBaseUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    public void setUserRoleRelationDao(UserRoleRelationDao userRoleRelationDao) {
        this.userRoleRelationDao = userRoleRelationDao;
    }

    @Override
    public User find(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public List<User> query(UserQuery query) {
        List<UserPO> list = userDao.getAll();
        return list.stream().map(userPO -> BeanUtil.toBean(userPO, User.class)).collect(Collectors.toList());
    }

    @Override
    public boolean remove(Long id) {
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public boolean save(User user) {
        if (Objects.isNull(user.getId())) {
            return addUser(user);
        }
        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    private boolean addUser(User user) {
        UserPO userPO = BeanUtil.toBean(user, UserPO.class);
        return userDao.insertOne(userPO);
    }

    @Override
    public User queryOne(UserQuery query) {
        if (Objects.nonNull(query.getUsername())) {
            UserPO userPO = userDao.getOneByField("username", query.getUsername());
            return BeanUtil.toBean(userPO, User.class);
        }

        throw new CommonException(ResultStatusEnum.BAD_REQUEST);
    }

    @Override
    public Boolean deleteUserRoleRelation(long userId) {
        return userRoleRelationDao.deleteUserRoleRelation(userId);
    }

    @Override
    public Boolean insertUserRoleRelation(long userId, long roleId) {
        UserRoleRelationPO userRoleRelationPO = new UserRoleRelationPO(userId, roleId);
        return userRoleRelationDao.insertUserRoleRelation(userRoleRelationPO);
    }

}
