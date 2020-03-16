package com.example.demo.Controller;

import com.example.demo.Entity.User;
import com.example.demo.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "",method = RequestMethod.GET)    public String hello() {
        return "hello";
    }


    @PostMapping("insert")
    @ResponseBody
    public Map insert(User user) {
        Map map = new HashMap();
        int i = 0;
        try {
            if(user!=null && user.getId()!=null){
                i = userService.updateMsg(user);
                map.put("code","0");
                map.put("msg","更新成功");
            }else {
                i = userService.insert(user);
                map.put("code","0");
                map.put("msg","新增成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","操作失败");
        }
        return map;
    }

    @PostMapping("findAll")
    @ResponseBody
    public Map findAll(String userName) {
        Map map = new HashMap();
        Map setMap = new HashMap();
         setMap.put("userName",userName);
        try {
            List<User> users = userService.findAll(setMap);


                map.put("code","0");
                map.put("data",users);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","查询失败");
        }
        return map;
    }

    @PostMapping("delete")
    @ResponseBody
    public Map delete(int id) {
        Map map = new HashMap();
        Map setMap = new HashMap();
        setMap.put("id",id);
        try {
            int i = 0;
            i = userService.delete(setMap);
            if(i>0){
                map.put("code","0");
                map.put("msg","删除成功");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code","-1");
            map.put("msg","删除失败");
        }
        return map;
    }
}
