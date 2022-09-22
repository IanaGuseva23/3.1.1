package com.pp.springboot.SpringBoot.services;

import com.pp.springboot.SpringBoot.models.User;

import java.util.List;

public interface UserService {
    User findOne(long id);

    List<User> findAll();

    void save(User user);

    void delete(long id);
    void update(User user);
}
