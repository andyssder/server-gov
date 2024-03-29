package com.politics.chn.common.secuity;

import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.service.user.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @since 2021-04-06
 * @author andyssder
 */
@Component
public class DynamicSecurityService {
    @Autowired
    private PermissionService permissionService;

    public Map<String, ConfigAttribute> loadDataSource() {
        Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
        List<Permission> permissions = permissionService.getPermissionList();
        for (Permission permission : permissions) {
            // TODO: 过滤掉不是后端接口的permission
            if (permission.getType() == 1) {
                continue;
            }
            if (!permission.getEnabled()) {
                continue;
            }
            map.put(permission.getMethod() + ":" + permission.getUri(), new SecurityConfig(permission.getId() + ":" + permission.getMethod() + "," + permission.getUri()));
        }
        return map;
    }
}
