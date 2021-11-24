package com.vlad.pp_311_3.service;

import com.vlad.pp_311_3.model.User;

import java.util.List;

public interface UserService {
    User findByName(String name);
    List<User> allUsers();
    void save(User user);
    void delete(Long id);
    User getById(Long id);
}
