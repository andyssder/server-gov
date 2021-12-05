package com.politics.chn.controller;

import com.politics.chn.application.UseBiz;
import com.politics.chn.domain.user.entity.Role;
import com.politics.chn.service.user.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since  2021-04-05
 * @author xu
 */
@RestController
@RequestMapping("/roles")
public class RoleController {

    @Autowired
    private UseBiz useBiz;

    @Autowired
    private RoleService roleService;

    @PostMapping
    public Long addRole(@RequestBody Role role) {
        return roleService.addRole(role);
    }

    @PutMapping
    public void updateRole(@RequestBody Role role) {
        roleService.updateRole(role);
    }

    @PutMapping(value = "/patch")
    public void patchUpdatePermission(@RequestBody List<Role> roles) {
        roleService.patchUpdateRole(roles);
    }

    @GetMapping
    public List<Role> getRoleList(@RequestParam(value = "user", required = false) Long userId) {
        if (userId == null) {
            return roleService.getRoleList();
        } else {
            return roleService.getRoleListByUser(userId);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deleteRole(@PathVariable long id) {
        roleService.deleteRole(id);
    }

    @PostMapping("/alloc/{id}")
    public void allocPermission(@PathVariable(value = "id") long roleId, @RequestBody List<Long> permissionIds) {
        useBiz.allocPermission(roleId, permissionIds);
    }

}
