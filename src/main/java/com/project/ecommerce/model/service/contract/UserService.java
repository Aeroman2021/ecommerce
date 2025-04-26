package com.project.ecommerce.model.service.contract;


import com.project.ecommerce.model.entity.User;
import com.project.ecommerce.model.service.GenericService;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends GenericService<User,Integer> {

}
