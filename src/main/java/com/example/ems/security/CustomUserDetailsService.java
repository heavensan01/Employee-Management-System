package com.example.ems.security;

import com.example.ems.repository.UserRepository;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository repo;
    public CustomUserDetailsService(UserRepository repo){this.repo=repo;}
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var u=repo.findByEmail(email).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return User.withUsername(u.getEmail()).password(u.getPassword()).roles(u.getRole().name()).build();
    }
}
