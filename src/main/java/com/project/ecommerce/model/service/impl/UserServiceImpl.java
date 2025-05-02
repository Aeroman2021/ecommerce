package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.Dto.UserDto;
import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.mapper.UserMapper;
import com.project.ecommerce.model.service.contract.UserService;
import com.project.ecommerce.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public User create(User user) {
        User insertedUser = User.builder()
                .name(user.getName())
                .username(user.getUsername())
                .password(passwordEncoder.encode(user.getPassword()))
                .auditFields(new AuditFields())
                .build();

        return userRepository.save(insertedUser);
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

    @Override
    public User createFromDto(UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }


}
