package com.example.demo.Dao;

import com.example.demo.Entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    int insert(User user);

    List<User> findAll(Map map);

    int delete(Map map);

    int updateMsg(User user);
}

