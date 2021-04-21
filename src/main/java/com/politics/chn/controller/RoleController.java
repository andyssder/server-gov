package com.politics.chn.controller;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 10:57
 */
@RestController
@RequestMapping("/roles")
@CrossOrigin
public class RoleController {

    private RoleService roleService;

    @Autowired
    private void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public Long addRole(@RequestBody RoleDO role) {
        return roleService.addRole(role);
    }

    @PutMapping
    public void updateRole(@RequestBody RoleDO role) {
        roleService.updateRole(role);
    }

    @PutMapping(value = "/patch")
    public void patchUpdatePermission(@RequestBody List<RoleDO> roles) {
        roleService.patchUpdateRole(roles);
    }

    @GetMapping
    public List<RoleDO> getRoleList(@RequestParam(value = "user", required = false) Long userId) {
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
    public void allocRole(@PathVariable(value = "id") long userId, @RequestBody List<Long> roleIds) {
        roleService.allocRole(userId, roleIds);
    }
}
