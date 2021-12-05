package com.politics.chn.service.user;

import com.politics.chn.domain.user.entity.User;
import com.politics.chn.domain.user.query.UserQuery;
import com.politics.chn.domain.user.repository.UserRepository;
import com.politics.chn.repo.user.repository.UserRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author xu
 * @since 2021-03-31 22:30
 */
@Repository
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setBaseUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User getUserByField(UserQuery userQuery) {
        return userRepository.queryOne(userQuery);
    }

    public boolean addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAll() {
        return userRepository.query(new UserQuery());
    }

    public boolean deleteUserRole(long userId) {
        return userRepository.deleteUserRoleRelation(userId);
    }

    public boolean addUserRole(long userId, long roleId) {
        return userRepository.insertUserRoleRelation(userId, roleId);
    }
}
