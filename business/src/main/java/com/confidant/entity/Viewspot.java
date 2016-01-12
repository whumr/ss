package com.confidant.entity;

import com.confidant.common.BaseEntity;

/**
 * Created by Administrator on 2015/11/27.
 */
public class Viewspot extends BaseEntity {

    private Integer id, province_id, parent_id;
    private String name, type, comments;
    private Province province;
    private Viewspot parent;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public Viewspot getParent() {
        return parent;
    }

    public void setParent(Viewspot parent) {
        this.parent = parent;
    }
}
