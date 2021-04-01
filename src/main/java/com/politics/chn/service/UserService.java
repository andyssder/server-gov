package com.politics.chn.service;

import com.politics.chn.common.utils.JwtTokenUtil;
import com.politics.chn.domain.user.Entity.UserInfoDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.repo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author xu
 * @create 2021-03-31 22:36
 */
@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDO getUserByUserName(String userName) {
        return userRepository.getUserByUsername(userName);
    }

    public String login(Map<String, String> loginParam) {
        String username = loginParam.get("username");
        String password = loginParam.get("password");
        String token = null;
        try {
            UserDO user = getUserByUserName(username);
            UserInfoDO userInfo = user.getUserInfoDO();
            if (!passwordEncoder.matches(password, userInfo.getPassword())) {
                throw new BadCredentialsException("密码不正确");
            }
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(authentication);
            token = jwtTokenUtil.generateToken(user);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
        return token;
    }
}
