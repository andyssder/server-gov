package com.politics.chn.controller;

import com.politics.chn.application.UseBiz;
import com.politics.chn.common.annotation.GlobalResultDisabled;
import com.politics.chn.common.result.ReturnResult;
import com.politics.chn.common.secuity.DynamicSecurityMetadataSource;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.entity.Role;
import com.politics.chn.service.user.PermissionService;
import com.politics.chn.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * @author xu
 * @since 2022-05-28
 */
@RestController
public class AuthController {

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Autowired
    private UseBiz useBiz;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

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

    @PostMapping("/users/alloc/{id}")
    public void allocRole(@PathVariable(value = "id") long userId, @RequestBody List<Long> roleIds) {
        useBiz.allocRole(userId, roleIds);
    }

    @PostMapping(value = "/roles")
    public Long addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PutMapping(value = "/roles")
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @PutMapping(value = "/roles/patch")
    public void patchUpdateRoles(@RequestBody List<Role> roles) {
        roleService.patchUpdateRole(roles);
    }

    @GetMapping(value = "/roles")
    public List<Role> getRoleList(@RequestParam(value = "user", required = false) Long userId) {
        if (userId == null) {
            return roleService.getRoleList();
        } else {
            return roleService.getRoleListByUser(userId);
        }
    }

    @DeleteMapping(value = "/roles/{id}")
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }

    @PostMapping("/roles/alloc/{id}")
    public void allocPermission(@PathVariable(value = "id") long roleId, @RequestBody List<Long> permissionIds) {
        useBiz.allocPermission(roleId, permissionIds);
    }

    @PostMapping(value = "/permissions")
    public Long addPermission(@RequestBody Permission permission) {
        long id = permissionService.addPermission(permission);
        dynamicSecurityMetadataSource.clearDataSource();
        return id;
    }

    @PutMapping(value = "/permissions")
    public void updatePermission(@RequestBody Permission permission) {
        permissionService.updatePermission(permission);
    }

    @PutMapping(value = "/permissions/patch")
    public void patchUpdatePermissions(@RequestBody List<Permission> permissions) {
        permissionService.patchUpdatePermissions(permissions);
    }

    @GetMapping(value = "/permissions")
    public List<Permission> getPermissionList(@RequestParam(value = "role", required = false) Long roleId ) {
        if (roleId == null) {
            return permissionService.getPermissionList();
        } else {
            return permissionService.getPermissionListByRole(roleId);
        }
    }

    @DeleteMapping(value = "/permissions/{id}")
    public void deletePermission(@PathVariable long id) {
        permissionService.deletePermission(id);
        dynamicSecurityMetadataSource.clearDataSource();
    }

}
