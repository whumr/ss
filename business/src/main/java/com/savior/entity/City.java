package com.savior.entity;

import com.savior.common.BaseEntity;

/**
 * Created by Administrator on 2015/11/26.
 */
public class City extends BaseEntity {
    private Integer id, province_id;
    private String name;

    private Province province;

    public Integer getId() {
        return id;
    }

    public Integer getProvince_id() {
        return province_id;
    }

    public void setProvince_id(Integer province_id) {
        this.province_id = province_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Province getProvince() {
        return province;
    }

    public void setProvince(Province province) {
        this.province = province;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
