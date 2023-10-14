package com.sangvaleap.lab8.service.impl;

import com.sangvaleap.lab8.model.User;
import com.sangvaleap.lab8.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = userRepository.findByEmail(username);
        System.out.println("=================");
        System.out.println(u.getUsername());
        System.out.println(u.getPassword());
        System.out.println(u.getEmail());
        System.out.println(u.getRoles().size());
        System.out.println(u.getAuthorities().size());
        System.out.println("=================");
        return u;
    }
}
