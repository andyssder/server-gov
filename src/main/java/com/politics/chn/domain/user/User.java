package com.politics.chn.domain.user;

import com.politics.chn.domain.user.Entity.RoleDO;
import com.politics.chn.domain.user.Entity.UserDO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;


/**
 * @author xu
 * @create 2021-03-31 21:36
 */
public class User implements UserDetails {
    private UserDO userDO;
    private List<RoleDO> roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return userDO.getPassword();
    }

    @Override
    public String getUsername() {
        return userDO.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return userDO.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return userDO.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return userDO.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return userDO.isEnabled();
    }
}
