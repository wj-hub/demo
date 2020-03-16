package com.example.demo.Controller;

import com.example.demo.Dao.ChinaCitysDao;
import com.example.demo.Entity.ChinaCitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("china")
@ResponseBody
public class ChinaCitysController {
    @Autowired
    private ChinaCitysDao dao;

    @PostMapping("getTree")
    public Map<String, Object> getTree(int id) {
        Map<String, Object> map = new HashMap<>();
        try {
            ChinaCitys province = dao.findProvince(id); //查询出一个省
            if (province != null) {
                List<ChinaCitys> citys = dao.findChildren(province.getId());//查询省下面的所有市
                digui(citys); //调用递归算法查询市以下的区县
                province.setChildren(citys);
            }
            map.put("data", province);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    public void digui(List<ChinaCitys> citys) {
        List<ChinaCitys> retList = new ArrayList<>();
        for (ChinaCitys c : citys) {
            retList = dao.findChildren(c.getId());
            if (retList.size() > 0) {
                c.setChildren(retList);
                digui(retList); //循环调用自己
            }
        }
    }
}
