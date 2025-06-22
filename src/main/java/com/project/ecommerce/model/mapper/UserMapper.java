package com.project.ecommerce.model.mapper;


import com.project.ecommerce.model.Dto.UserDto;
import com.project.ecommerce.model.entity.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDto userDto);
    UserDto toEntity(User user);
}
