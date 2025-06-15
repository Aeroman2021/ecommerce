package com.project.ecommerce.service.contract;


import com.project.ecommerce.model.Dto.UserDto;
import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.dao.GenericDao;


public interface UserService extends GenericDao<User,Integer> {
    User createFromDto(UserDto userDto);

}
