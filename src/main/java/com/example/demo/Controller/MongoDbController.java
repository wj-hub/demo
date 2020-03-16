package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.MongodbService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("Mongodb")
public class MongoDbController {

    @Autowired
    private UserService userService;
    @Autowired
    private MongodbService mongodbService;

    @PostMapping("testInsert")
    @ResponseBody
    public Map insert(User user) {
        Map map = new HashMap();
        try {
            //执行插入数据的时候，如果没有数据库和集合，则会自动创建
            MongoTemplate mongoTemplate = mongodbService.getMongoTemplate("user");
            mongoTemplate.save(user);

            List<User> users = mongoTemplate.findAll(User.class, "user");
            map.put("data", users);
        } catch (Exception e) {
            map.put("msg", "异常");
           e.printStackTrace();
        }
        return map;
    }
}
