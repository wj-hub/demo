package com.example.demo.Dao;

import com.example.demo.Entity.Login;
import com.example.demo.Entity.User;

import java.util.List;
import java.util.Map;

public interface LoginDao {
    int insert(Login login);

    List<User> findAll(Login login);

    int delete(int id);

    Login findOne(Map map);
}

