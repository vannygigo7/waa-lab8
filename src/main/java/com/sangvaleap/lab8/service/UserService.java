package com.sangvaleap.lab8.service;

import com.sangvaleap.lab8.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
}
