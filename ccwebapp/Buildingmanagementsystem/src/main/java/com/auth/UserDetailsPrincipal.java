package com.auth;

import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserDetailsPrincipal implements UserDetails {
    @Autowired
    private User user;;
    @Autowired
    private List<AuthGroup> authGroupList;

    public UserDetailsPrincipal(User user,List<AuthGroup> authGroupList) {
    this.user=user;
    this.authGroupList=authGroupList;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if(null == authGroupList){
            Collections.emptyList();

        }
        Set<SimpleGrantedAuthority> grantedAuthoritySet = new HashSet<>();
        authGroupList.forEach(group->{
            grantedAuthoritySet.add(new SimpleGrantedAuthority(group.getAuthGroup()));
        });
        return grantedAuthoritySet;
    }

    @Override
    public String getPassword() {
        return this.user.getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.getUsername();
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
