package com.nio.chapter04.serverObjectClient;

import java.io.Serializable;

/**
 * @Description UserInfo
 * @Author sunlei19
 * @Date 2020/9/8 16:36
 * @Version 1.0
 */
public class UserInfo implements Serializable {

    private static final long serialVersionUID = 1156691302945225607L;
    private long id;
    private String userName;
    private String password;

    public UserInfo() {
    }

    public UserInfo(long id, String userName, String password) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
