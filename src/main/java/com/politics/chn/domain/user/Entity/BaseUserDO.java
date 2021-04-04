package com.politics.chn.domain.user.Entity;

import java.util.*;

/**
 * @author xu
 * @create 2021-03-31 21:05
 */
public class BaseUserDO {

    private Long id;

    private String username;
    private String password;

    private String icon;
    private String description;

    private String email;
    private String phone;

    private Date createTime;
    private Date loginTime;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public boolean isAccountNonExpired() {
        return isAccountNonExpired();
    }

    public void setAccountNonExpired(boolean accountNonExpired) {
        this.accountNonExpired = accountNonExpired;
    }

    public boolean isAccountNonLocked() {
        return isAccountNonLocked();
    }

    public void setAccountNonLocked(boolean accountNonLocked) {
        this.accountNonLocked = accountNonLocked;
    }

    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    public void setCredentialsNonExpired(boolean credentialsNonExpired) {
        this.credentialsNonExpired = credentialsNonExpired;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BaseUserDO baseUserDO = (BaseUserDO) o;
        return accountNonExpired == baseUserDO.accountNonExpired && accountNonLocked == baseUserDO.accountNonLocked && credentialsNonExpired == baseUserDO.credentialsNonExpired && enabled == baseUserDO.enabled && Objects.equals(id, baseUserDO.id) && Objects.equals(username, baseUserDO.username) && Objects.equals(password, baseUserDO.password) && Objects.equals(icon, baseUserDO.icon) && Objects.equals(description, baseUserDO.description) && Objects.equals(email, baseUserDO.email) && Objects.equals(phone, baseUserDO.phone) && Objects.equals(createTime, baseUserDO.createTime) && Objects.equals(loginTime, baseUserDO.loginTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, icon, description, email, phone, createTime, loginTime, accountNonExpired, accountNonLocked, credentialsNonExpired, enabled);
    }

    @Override
    public String toString() {
        return "BaseUserDO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", icon='" + icon + '\'' +
                ", description='" + description + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", createTime=" + createTime +
                ", loginTime=" + loginTime +
                ", accountNonExpired=" + accountNonExpired +
                ", accountNonLocked=" + accountNonLocked +
                ", credentialsNonExpired=" + credentialsNonExpired +
                ", enabled=" + enabled +
                '}';
    }

    public boolean isNotNull() {
        return username != null && password != null;
    }
}