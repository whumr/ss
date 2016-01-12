package com.confidant.entity;

import com.confidant.common.BaseEntity;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Country extends BaseEntity {
    private Integer id;
    private String name, type;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
