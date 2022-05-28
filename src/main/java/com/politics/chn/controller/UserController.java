package com.politics.chn.controller;

import com.politics.chn.application.dto.UserAuthDTO;
import com.politics.chn.domain.user.entity.User;
import com.politics.chn.application.UseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @since 2021-03-31
 * @author andyssder
 */
@RestController
public class UserController {
    @Autowired
    private UseBiz useBiz;

    @PostMapping(value = "/register")
    public void register(@RequestBody User registerUser) {
        useBiz.register(registerUser);
    }

    @GetMapping(value = "/users/details")
    public UserAuthDTO getUserInfo(Principal principal) {
        // TODO 优化返回值
        String username = principal.getName();
        return useBiz.getUserByUserName(username);
    }

    @GetMapping(value = "/users")
    public List<User> getUserList() {
        return useBiz.getUserList();
    }
}
