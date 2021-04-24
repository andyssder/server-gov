package com.politics.chn.domain.user;

import com.politics.chn.domain.user.Entity.BaseUserDO;
import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author xu
 * @create 2021-03-31 21:36
 */
public class UserDO implements UserDetails {
    private BaseUserDO baseUser;
    private List<RoleDO> roles;
    private List<PermissionDO> permissions;

    public UserDO() {
    }

    public UserDO(BaseUserDO baseUser, List<RoleDO> roles, List<PermissionDO> permissions) {
        this.baseUser = baseUser;
        this.roles = roles;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 过滤掉不属于后端接口的权限
        return permissions.stream()
                .filter(permission -> permission.getType() != 1)
                .map(permission ->new SimpleGrantedAuthority(permission.getId() + ":" + permission.getMethod() + "," + permission.getUri()))
                .collect(Collectors.toList());
    }

    @Override
    public String getPassword() {
        return baseUser.getPassword();
    }

    @Override
    public String getUsername() {
        return baseUser.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return baseUser.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return baseUser.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return baseUser.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return baseUser.getEnabled();
    }


    public BaseUserDO getBaseUser() {
        return baseUser;
    }

    public void setBaseUser(BaseUserDO baseUser) {
        this.baseUser = baseUser;
    }

    public List<RoleDO> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleDO> roles) {
        this.roles = roles;
    }

    public List<PermissionDO> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<PermissionDO> permissions) {
        this.permissions = permissions;
    }

}
