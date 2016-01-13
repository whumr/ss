package com.savior.entity;

import com.savior.common.BaseEntity;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Country extends BaseEntity {
    private Integer id;
    private String name;

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
}
