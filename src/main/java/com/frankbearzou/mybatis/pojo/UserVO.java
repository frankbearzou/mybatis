package com.frankbearzou.mybatis.pojo;

public class UserVO {
    private User user;

    public UserVO() {
    }

    public UserVO(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
