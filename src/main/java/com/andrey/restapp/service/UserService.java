package com.andrey.restapp.service;

import com.andrey.restapp.model.User;

import java.util.List;

public interface UserService {
    public User getById(Long id);

    public User create(User user);

    public List<User> getAll();

    public  User update(User user);

    public void delete(Long id);

}
