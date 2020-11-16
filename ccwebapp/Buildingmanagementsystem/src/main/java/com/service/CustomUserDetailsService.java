package com.service;


import com.auth.AuthGroup;
import com.auth.UserDetailsPrincipal;
import com.dao.AuthGroupRepository;
import com.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.stereotype.Service;

import com.dao.UserRepository;


import java.util.List;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthGroupRepository authGroupRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<AuthGroup> authogroups= this.authGroupRepository.findByUsername(userName);
        return new UserDetailsPrincipal(user,authogroups) ;
    }

}