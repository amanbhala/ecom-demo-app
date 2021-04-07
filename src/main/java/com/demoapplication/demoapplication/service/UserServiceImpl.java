package com.demoapplication.demoapplication.service;

import com.demoapplication.demoapplication.model.Role;
import com.demoapplication.demoapplication.model.User;
import com.demoapplication.demoapplication.repository.RoleRepository;
import com.demoapplication.demoapplication.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        // user.setRoles(new HashSet<>(roleRepository.findAll()));
        if (user.getUser_type().equals("customer")) {
            Set<Role> roleset = new HashSet<>();
            roleset.add(roleRepository.findByName("ROLE_USER").orElseGet(() -> {
                Role role = new Role();
                role.setName("ROLE_USER");
                return roleRepository.save(role);
            }));
            user.setRoles(roleset);
        }
        if (user.getUser_type().equals("supplier")) {
            Set<Role> roleset = new HashSet<>();
            roleset.add(roleRepository.findByName("ROLE_ADMIN").orElseGet(() -> {
                Role role = new Role();
                role.setName("ROLE_ADMIN");
                return roleRepository.save(role);
            }));
            user.setRoles(roleset);
        }
        userRepository.save(user);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
