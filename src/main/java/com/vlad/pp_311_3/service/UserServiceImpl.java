package com.vlad.pp_311_3.service;

import com.vlad.pp_311_3.repositories.RoleRepository;
import com.vlad.pp_311_3.repositories.UserRepository;
import com.vlad.pp_311_3.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }


    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getById(Long id) {
        User user = null;
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            user = userOptional.get();
        }
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.vlad.pp_311_3.model.User user = userRepository.findByName(username);
        if (user == null) {
            throw new UsernameNotFoundException("GoodBye=)");
        } else {
            return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), user.getAuthorities());
        }

    }
}
