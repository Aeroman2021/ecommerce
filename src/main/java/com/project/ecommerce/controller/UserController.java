package com.project.ecommerce.controller;

import com.project.ecommerce.model.Dto.UserDto;
import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.service.contract.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/add")
    public ResponseEntity<User> add(@RequestBody @Validated UserDto userDto){
        User user = userService.createFromDto(userDto);
        return ResponseEntity.ok(userService.create(user));
    }
}
