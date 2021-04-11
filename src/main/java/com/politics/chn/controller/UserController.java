package com.politics.chn.controller;

import com.politics.chn.common.annotation.GlobalResultDisabled;
import com.politics.chn.common.result.ReturnResult;
import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.UserDO;
import com.politics.chn.service.PermissionService;
import com.politics.chn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.HashMap;
import java.util.Map;


/**
 * @author xu
 * @create 2021-03-31 22:39
 */
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private PermissionService permissionService;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @GlobalResultDisabled
    @PostMapping(value = "/login")
    public ReturnResult login(HttpServletResponse response, @RequestBody Map<String, String> loginParam) {
        String token = userService.login(loginParam);
        Cookie tokenCookie = new Cookie("token", tokenHead + token);
        tokenCookie.setHttpOnly(true);
        response.addCookie(tokenCookie);
        response.addCookie(new Cookie("loginState", "true"));
        return ReturnResult.success();
    }

    @PostMapping(value = "/register")
    public void register(@RequestBody BaseUserDO registerUser) {
        userService.register(registerUser);
    }

    @RequestMapping(value = "/user/details", method = RequestMethod.GET)
    @ResponseBody
    public Map<String, Object> getAdminInfo(Principal principal) {
        if(principal==null){
            return null;
        }
        String username = principal.getName();
        UserDO user = userService.getUserByUserName(username);

        Map<String, Object> result = new HashMap<>();
        result.put("username", user.getUsername());
        result.put("permissions", user.getPermissions());
        return result;
    }
}
