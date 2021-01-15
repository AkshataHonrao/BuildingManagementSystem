package com.example.rentalapp.services;

import com.example.rentalapp.auth.UserDetailsPrincipal;
import com.example.rentalapp.models.AuthGroup;
import com.example.rentalapp.respositories.AuthGroupRepository;
import com.example.rentalapp.respositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.rentalapp.models.User;

import java.util.List;

@Service
public class UserService implements UserDetailsService {


    @Autowired
    private AuthGroupRepository authGroupRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        User user = userRepository.findUserByEmail(userName);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<AuthGroup> authogroups= this.authGroupRepository.findByUsername(userName);


        return new UserDetailsPrincipal(user,authogroups) ;
    }
}
