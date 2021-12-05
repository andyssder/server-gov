package com.politics.chn.application.dto;

import com.politics.chn.domain.user.entity.Permission;
import com.politics.chn.domain.user.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @since 2021-03-31
 * @author xu
 */
public class UserAuthDTO implements UserDetails {
    private User user;
    private List<Permission> permissions;

    public UserAuthDTO() {
    }

    public UserAuthDTO(User user, List<Permission> permissions) {
        this.user = user;
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
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.getAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.getAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.getCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return user.getEnabled();
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }

}
