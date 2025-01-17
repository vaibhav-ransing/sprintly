package com.sprintly.sprintly.security;

import com.sprintly.sprintly.entity.User;
import com.sprintly.sprintly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String emailID) throws UsernameNotFoundException {

        return userRepository.findByEmailID(emailID)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with username: " + emailID));
    }
}
