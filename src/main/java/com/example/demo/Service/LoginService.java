package com.example.demo.Service;

import com.example.demo.Dao.LoginDao;
import com.example.demo.Dao.UserDao;
import com.example.demo.Entity.Login;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LoginService {
    @Autowired
    private LoginDao loginDao;

    int insert(Login login) {
        return loginDao.insert(login);
    }

    List<User> findAll(Login login) {
        return loginDao.findAll(login);
    }

    int delete(int id) {
        return loginDao.delete(id);
    }

    Login findOne(Map map) {
        return loginDao.findOne(map);
    }
}
