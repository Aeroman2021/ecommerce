package com.project.ecommerce.dao.userDao.UserDaoImpl;

import com.project.ecommerce.dao.daoImpl.GenericDaoImpl;
import com.project.ecommerce.dao.userDao.UserDao;
import com.project.ecommerce.model.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User,Integer> implements UserDao {
    public UserDaoImpl() {
        super(User.class);
    }
}


