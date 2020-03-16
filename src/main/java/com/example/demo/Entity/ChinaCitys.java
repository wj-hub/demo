package com.example.demo.Entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "china_citys")
public class ChinaCitys {
    @Id
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "level")
    private Integer level;
    @Column(name = "code")
    private String code;
    @Column(name = "upcode")
    private String upcode;
    @Column(name = "upid")
    private Integer upid;
    @Column(name = "is_use")
    private Integer isUse;
    private List<ChinaCitys> children;

    public List<ChinaCitys> getChildren() {
        return children;
    }

    public void setChildren(List<ChinaCitys> children) {
        this.children = children;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpcode() {
        return upcode;
    }

    public void setUpcode(String upcode) {
        this.upcode = upcode;
    }

    public Integer getUpid() {
        return upid;
    }

    public void setUpid(Integer upid) {
        this.upid = upid;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }
}
