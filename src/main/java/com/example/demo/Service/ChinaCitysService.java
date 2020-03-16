package com.example.demo.Service;

import com.example.demo.Dao.ChinaCitysDao;
import com.example.demo.Entity.ChinaCitys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChinaCitysService {
    @Autowired
    private ChinaCitysDao chinaCitysDao;

    ChinaCitys findProvince(int id){
        return chinaCitysDao.findProvince(id);
    }
    List<ChinaCitys> findChildren(int id){
        return chinaCitysDao.findChildren(id);
    }

}
