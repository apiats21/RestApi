package com.andrey.restapp.service.impl;

import com.andrey.restapp.model.User;
import com.andrey.restapp.repository.UserRepository;
import com.andrey.restapp.repository.hibernate.HibernateUserRepositoryImpl;
import com.andrey.restapp.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    private final UserRepository userRepository = new HibernateUserRepositoryImpl();

    @Override
    public User getById(Long id) { return userRepository.getById(id); }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAll() { return userRepository.getAll(); }

    @Override
    public User update(User user) { return userRepository.update(user); }

    @Override
    public void delete(Long id) { userRepository.deleteById(id); }
}
