package com.confidant.entity;

import com.confidant.common.BaseEntity;

/**
 * Created by Administrator on 2015/11/26.
 */
public class Province extends BaseEntity {
    private Integer id, country_id;
    private String name;

    private Country country;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountry_id() {
        return country_id;
    }

    public void setCountry_id(Integer country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
