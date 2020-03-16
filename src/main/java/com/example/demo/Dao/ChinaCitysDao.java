package com.example.demo.Dao;

import com.example.demo.Entity.ChinaCitys;

import java.util.List;

public interface ChinaCitysDao {
    ChinaCitys findProvince(int id);
    List<ChinaCitys> findChildren(int id);
}
