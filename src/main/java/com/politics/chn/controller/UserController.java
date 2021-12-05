package com.politics.chn.controller;

import com.politics.chn.application.dto.UserAuthDTO;
import com.politics.chn.common.annotation.GlobalResultDisabled;
import com.politics.chn.common.result.ReturnResult;
import com.politics.chn.domain.user.entity.User;
import com.politics.chn.application.UseBiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.List;
import java.util.Map;


/**
 * @since 2021-03-31
 * @author xu
 */
@RestController
public class UserController {
    @Autowired
    private UseBiz useBiz;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @GlobalResultDisabled
    @PostMapping(value = "/login")
    public ReturnResult login(HttpServletResponse response, @RequestBody Map<String, String> loginParam) {
        String token = useBiz.login(loginParam);
        Cookie tokenCookie = new Cookie("token", tokenHead + token);
        tokenCookie.setHttpOnly(true);
        response.addCookie(tokenCookie);
        response.addCookie(new Cookie("loginState", "true"));
        return ReturnResult.success();
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody User registerUser) {
        useBiz.register(registerUser);
    }

    @GetMapping(value = "/users/details")
    public UserAuthDTO getUserInfo(Principal principal) {
        String username = principal.getName();
        return useBiz.getUserByUserName(username);
    }

    @GetMapping(value = "/users")
    public List<User> getUserList() {
        return useBiz.getUserList();
    }

    @PostMapping("/users/alloc/{id}")
    public void allocRole(@PathVariable(value = "id") long userId, @RequestBody List<Long> roleIds) {
        useBiz.allocRole(userId, roleIds);
    }
}
