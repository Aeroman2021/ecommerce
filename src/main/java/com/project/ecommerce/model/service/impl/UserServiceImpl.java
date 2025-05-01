package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.model.service.contract.UserService;
import com.project.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public User create(User entity) {
        return userRepository.save(entity);
    }

    @Override
    public User update(Integer integer, User user) {
        return null;
    }

    @Override
    public Optional<User> getById(Integer id) {
        return userRepository.findById(id);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        userRepository.deleteById(id);
    }
}
