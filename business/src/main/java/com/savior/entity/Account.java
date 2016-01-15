package com.savior.entity;

import com.savior.common.BaseEntity;

import java.util.Date;

/**
 * Created by Administrator on 2015/1/29.
 */
public class Account extends BaseEntity {

    private Long id;
    private String mobile, password, nick_name, last_token;
    private Date create_date, last_login;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick_name() {
        return nick_name;
    }

    public void setNick_name(String nick_name) {
        this.nick_name = nick_name;
    }

    public Date getCreate_date() {
        return create_date;
    }

    public String getLast_token() {
        return last_token;
    }

    public void setLast_token(String last_token) {
        this.last_token = last_token;
    }

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date last_login) {
        this.last_login = last_login;
    }

    public void setCreate_date(Date create_date) {
        this.create_date = create_date;
    }
}
