package com.politics.chn.controller;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author xu
 * @create 2021-04-05 10:59
 */
@RestController
@RequestMapping("/permissions")
@CrossOrigin
public class PermissionController {

    private PermissionService permissionService;

    @Autowired
    private void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @PostMapping
    public Long addPermission(@RequestBody PermissionDO permission) {
        return permissionService.addPermission(permission);
    }

    @PutMapping
    public void updatePermission(@RequestBody PermissionDO permission) {
        permissionService.updatePermission(permission);
    }

    @GetMapping
    public List<PermissionDO> getPermissionList() {
        return permissionService.getPermissionList();
    }

    @DeleteMapping(value = "/{id}")
    public void deletePermission(@PathVariable long id) {
        permissionService.deletePermission(id);
    }
}
