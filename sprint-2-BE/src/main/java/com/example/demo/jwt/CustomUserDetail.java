package com.example.demo.jwt;


import com.example.demo.model.user1.User;
import com.example.demo.model.user1.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class  CustomUserDetail implements UserDetails {
    private User user;

    public CustomUserDetail(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<UserRole> list = user.getUserRole();
        System.out.println(list);
        List<GrantedAuthority>grantedAuthorityList = new ArrayList<>();

        for (UserRole temp: list) {
            GrantedAuthority authority = new SimpleGrantedAuthority(temp.getRole().getNameRole());
            grantedAuthorityList.add(authority);
        }
        return grantedAuthorityList;
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
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
