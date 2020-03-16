package com.example.demo.Controller;

import com.example.demo.Dao.LoginDao;
import com.example.demo.Entity.Login;
import com.example.demo.Entity.User;
import com.example.demo.Service.LoginService;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class LoginController {

    @Autowired
    private LoginService loginService;
    @Autowired
    private LoginDao loginDao;

    @PostMapping("insert")
    @ResponseBody
    public Map insert(Login login) {
        Map map = new HashMap();
        int i = 0;
        try {
            BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
            String padJM = encode.encode(login.getPassword());
            login.setPassword(padJM);
            login.setCreateDate(new Date());
            i = loginDao.insert(login);
            map.put("code", "0");
            map.put("msg", "新增成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "操作失败");
        }
        return map;
    }

    @PostMapping("login")
    @ResponseBody
    public Map findAll(String userName, String password) {
        Map map = new HashMap();
        Map setMap = new HashMap();
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String padJM = encode.encode(password);
        setMap.put("userName", userName);
        try {
            Login login = new Login();
            login = loginDao.findOne(setMap);
            if (login != null) {
                if (encode.matches(password, login.getPassword())) {
                    map.put("code", "0");
                    map.put("msg", "登录成功");
                } else {
                    map.put("code", "1");
                    map.put("msg", "用户名或密码错误");
                }
            } else {
                map.put("code", "2");
                map.put("msg", "用户不存在");
            }

        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "查询异常");
        }
        return map;
    }

    @PostMapping("register")
    @ResponseBody
    public Map register(String userName, String password,String repeatPsd) {
        Map map = new HashMap();
        Map setMap = new HashMap();
        Login loginInsert = new Login();
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        String padJM = encode.encode(password);
        try {
            setMap.put("userName", userName);
            Login login = loginDao.findOne(setMap);
            if (login == null) {
                if(password.equals(repeatPsd)){
                    loginInsert.setUserName(userName);
                    loginInsert.setPassword(padJM);
                    loginInsert.setCreateDate(new Date());
                    loginInsert.setCreateBy("admin");
                    loginDao.insert(loginInsert);
                    map.put("code", "0");
                    map.put("msg", "注册成功！");
                }else {
                    map.put("code", "-2");
                    map.put("msg", "输入密码前后不一致，请重新输入！");
                }
            } else {

                map.put("code", "2");
                map.put("msg", "该用户已注册过");
            }
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code", "-1");
            map.put("msg", "注册异常");
        }
        return map;
    }
}
