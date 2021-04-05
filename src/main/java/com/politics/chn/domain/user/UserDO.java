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
import java.util.stream.Stream;


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
        List<SimpleGrantedAuthority> roleList = roles.stream().
                filter(role -> role.getName() != null)
                .map(role -> new SimpleGrantedAuthority("Role_" + role.getName()))
                .collect(Collectors.toList());

        List<SimpleGrantedAuthority> permissionList =  permissions.stream()
                .filter(permission -> permission.getDescription()!=null)
                .map(permission ->new SimpleGrantedAuthority(permission.getDescription()))
                .collect(Collectors.toList());
        return Stream.concat(roleList.stream(), permissionList.stream())
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
        return baseUser.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return baseUser.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return baseUser.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return baseUser.isEnabled();
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
