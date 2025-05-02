package com.project.ecommerce.model.service.contract;


import com.project.ecommerce.model.Dto.UserDto;
import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.model.service.GenericService;
import org.springframework.stereotype.Service;


public interface UserService extends GenericService<User,Integer> {
    User createFromDto(UserDto userDto);

}
