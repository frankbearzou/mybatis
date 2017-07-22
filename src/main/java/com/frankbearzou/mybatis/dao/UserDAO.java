package com.frankbearzou.mybatis.dao;

import com.frankbearzou.mybatis.User;

import java.util.List;

public interface UserDAO {
    public User findUserById(int id);
    public List<User> findUserByName(String name);
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public void deleteUser(User user);
}
