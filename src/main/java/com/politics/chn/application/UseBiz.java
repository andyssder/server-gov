package com.politics.chn.application;

import com.politics.chn.common.enums.ResultStatusEnum;
import com.politics.chn.common.exception.CommonException;
import com.politics.chn.common.utils.JwtTokenUtil;
import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.RolePermissionRelation;
import com.politics.chn.domain.user.Entity.UserRoleRelation;
import com.politics.chn.domain.user.UserDO;
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

    public UserDO getUserByUserName(String userName) {
        return userService.getUserByField("username", userName);
    }

    public UserDO getUserByEmail(String email) {
        return userService.getUserByField("email", email);
    }

    public UserDO getUserByPhone(String phone) {
        return userService.getUserByField("phone", phone);
    }

    public String login(Map<String, String> loginParam) {
        Assert.isTrue(loginParam.containsKey("username") && loginParam.containsKey("password"), () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND);
        });

        String username = loginParam.get("username").trim();
        String password = loginParam.get("password");
        Assert.isTrue(username != null && password != null, () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });
        UserDO user = getUserByUserName(username);
        Assert.notNull(user, () -> {
            throw new CommonException(ResultStatusEnum.NOT_FOUND.getCode(), "用户不存在!");
        });

        BaseUserDO baseUser = user.getBaseUser();
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

    public void register(BaseUserDO baseUser) {
        Assert.isTrue(baseUser.isNotNull(), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST);
        });

        baseUser.setUsername(baseUser.getUsername().trim());
        baseUser.setCreateTime(new Date());

        Assert.isNull(getUserByUserName(baseUser.getUsername()), () -> {
            throw new CommonException(ResultStatusEnum.BAD_REQUEST.getCode(), "用户名已经存在!");
        });

        //将密码进行加密操作
        String encodePassword = passwordEncoder.encode(baseUser.getPassword());
        baseUser.setPassword(encodePassword);

        userService.addUser(baseUser);

    }

    public List<BaseUserDO> getUserList() {
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
