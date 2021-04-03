package com.politics.chn.domain.user;

import com.politics.chn.domain.user.Entity.PermissionDO;
import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserInfoDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


/**
 * @author xu
 * @create 2021-03-31 21:36
 */
public class UserDO implements UserDetails {
    private UserInfoDO userInfoDO;
    private List<RoleDO> roles;
    private List<PermissionDO> permissions;

    public UserDO() {
    }

    public UserDO(UserInfoDO userInfoDO, List<RoleDO> roles, List<PermissionDO> permissions) {
        this.userInfoDO = userInfoDO;
        this.roles = roles;
        this.permissions = permissions;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userInfoDO.getPassword();
    }

    @Override
    public String getUsername() {
        return userInfoDO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userInfoDO.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userInfoDO.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userInfoDO.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userInfoDO.isEnabled();
    }


    public UserInfoDO getUserInfoDO() {
        return userInfoDO;
    }

    public void setUserInfoDO(UserInfoDO userInfoDO) {
        this.userInfoDO = userInfoDO;
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
