package com.politics.chn.controller;

import com.politics.chn.common.annotation.GlobalResultDisabled;
import com.politics.chn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


/**
 * @author xu
 * @create 2021-03-31 22:39
 */
@RestController
public class UserController {
    private UserService userService;

    @Autowired
    private void setPitService(UserService userService) {
        this.userService = userService;
    }

    @GlobalResultDisabled
    @PostMapping(value = "/login")
    public String login(@RequestBody Map<String, String> loginParam) {

        return userService.login(loginParam);
    }

    @PostMapping(value = "/register")
    public void register() {
        return;
    }
}
