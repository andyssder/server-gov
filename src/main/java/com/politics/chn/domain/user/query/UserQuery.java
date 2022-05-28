package com.politics.chn.domain.user.query;

import com.politics.chn.domain.common.Query;
import com.politics.chn.domain.user.entity.User;

/**
 * @author andyssder
 * @since 2021-12-05
 */
public class UserQuery implements Query<User> {
    private String username;

    private String email;

    private String phone;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
