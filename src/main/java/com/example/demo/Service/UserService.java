package com.example.demo.Service;

import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public int insert(User user) {
        return userDao.insert(user);
    }

    public List<User> findAll(Map map) {
        return userDao.findAll(map);
    }

    public int delete(Map map) {
        return userDao.delete(map);
    }

    public int updateMsg(User user) {
        return userDao.updateMsg(user);
    }
}
