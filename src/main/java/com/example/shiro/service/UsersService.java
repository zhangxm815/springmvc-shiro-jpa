package com.example.shiro.service;

import com.example.shiro.dao.UsersDao;
import com.example.shiro.pojo.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    @Autowired
    private UsersDao usersDao;

    public Users getUserByUserName(String userName) {
        List<Users> list = usersDao.findUsersByUserName(userName);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }
}
