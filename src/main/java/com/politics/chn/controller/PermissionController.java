package com.politics.chn.controller;

import com.politics.chn.common.secuity.DynamicSecurityMetadataSource;
import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @since 2021-04-05
 * @author xu
 */
@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private PermissionService permissionService;

    private DynamicSecurityMetadataSource dynamicSecurityMetadataSource;

    @Autowired
    private void setPermissionService(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @Autowired
    public void setDynamicSecurityMetadataSource(DynamicSecurityMetadataSource dynamicSecurityMetadataSource) {
        this.dynamicSecurityMetadataSource = dynamicSecurityMetadataSource;
    }

    @PostMapping
    public Long addPermission(@RequestBody Permission permission) {
        long id = permissionService.addPermission(permission);
        dynamicSecurityMetadataSource.clearDataSource();
        return id;
    }

    @PutMapping
    public void updatePermission(@RequestBody Permission permission) {
        permissionService.updatePermission(permission);
    }

    @PutMapping(value = "/patch")
    public void patchUpdatePermission(@RequestBody List<Permission> permissions) {
        permissionService.patchUpdatePermission(permissions);
    }

    @GetMapping
    public List<Permission> getPermissionList(@RequestParam(value = "role", required = false) Long roleId ) {
        if (roleId == null) {
            return permissionService.getPermissionList();
        } else {
            return permissionService.getPermissionListByRole(roleId);
        }
    }

    @DeleteMapping(value = "/{id}")
    public void deletePermission(@PathVariable long id) {
        permissionService.deletePermission(id);
        dynamicSecurityMetadataSource.clearDataSource();
    }

}
