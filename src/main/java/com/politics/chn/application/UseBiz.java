package com.politics.chn.application;

import com.politics.chn.application.dto.UserAuthDTO;
import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.common.utils.JwtTokenUtil;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.entity.User;
import com.politics.chn.domain.user.query.UserQuery;
import com.politics.chn.service.user.PermissionService;
import com.politics.chn.service.user.RoleService;
import com.politics.chn.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @since 2021-03-31 22:36
 */
@Service
public class UseBiz {

    private UserService userService;

    private RoleService roleService;

    private PermissionService permissionService;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Autowired
    public void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    public UserAuthDTO getUserByUserName(String userName) {
        UserQuery userQuery = new UserQuery();
        userQuery.setUsername(userName);
        User user = userService.getUserByField(userQuery);

        Assert.notNull(user, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST.getCode(), "用户不存在");
        });

        long id = user.getId();
        List<Permission> permissions = permissionService.getPermissionListByRole(id);

        return new UserAuthDTO(user, permissions);
    }

//    public UserAuthDTO getUserByEmail(String email) {
//        return userService.getUserByField("email", email);
//    }
//
//    public UserAuthDTO getUserByPhone(String phone) {
//        return userService.getUserByField("phone", phone);
//    }

    public String login(Map<String, String> loginParam) {
        Assert.isTrue(loginParam.containsKey("username") && loginParam.containsKey("password"), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        String username = loginParam.get("username").trim();
        String password = loginParam.get("password");
        Assert.isTrue(username != null && password != null, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        UserAuthDTO user = getUserByUserName(username);
        Assert.notNull(user, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND.getCode(), "用户不存在!");
        });

        User baseUser = user.getUser();
        boolean passwordCheckResult = passwordEncoder.matches(password, baseUser.getPassword());
        Assert.isTrue(passwordCheckResult, () -> {
            throw new BadCredentialsException("密码不正确!");
        });

        // 更新登录时间

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtTokenUtil.generateToken(user);
        return token;
    }

    public void register(User baseUser) {
        Assert.isTrue(baseUser.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        baseUser.setUsername(baseUser.getUsername().trim());
        baseUser.setCreateTime(new Date());

        UserQuery userQuery = new UserQuery();
        userQuery.setUsername(baseUser.getUsername());
        User user = userService.getUserByField(userQuery);

        Assert.isNull(user, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST.getCode(), "用户名已经存在!");
        });

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(baseUser.getPassword());
        baseUser.setPassword(encodePassword);

        userService.addUser(baseUser);

    }

    public List<User> getUserList() {
        return userService.getAll();
    }

    public void allocRole(long userId, List<Long> roleIds) {
        // TODO: 暂时不维护角色的用户数
        Assert.isTrue(userService.deleteUserRole(userId), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });

        if (roleIds == null || roleIds.size() == 0) {
            return;
        }

        roleIds.forEach(roleId -> {
            userService.addUserRole(userId, roleId);
        });
    }

    public void allocPermission(long roleId, List<Long> permissionIds) {
        Assert.isTrue(roleService.deletePermission(roleId), () -> {
            throw new CommonException(ResultStatusEnum.INTERNAL_SERVER_ERROR);
        });

        if (permissionIds == null || permissionIds.size() == 0) {
            return;
        }

        permissionIds.forEach(permissionId -> {
            roleService.addRolePermission(roleId, permissionId);
        });
    }
}
