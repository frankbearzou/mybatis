package com.frankbearzou.mybatis.mapper;

import com.frankbearzou.mybatis.pojo.User;
import com.frankbearzou.mybatis.pojo.UserCustom;
import com.frankbearzou.mybatis.pojo.UserVO;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    public User findUserById(int id);
    public List<User> findUserByName(String name);
    public int findUserCount(UserVO userVO);
    public List<UserCustom> findUserList(UserVO userVO);
    public List<Map<String, Object>> findUserAmount();
    public void addUser(User user);
    public void updateUser(User user);
    public void deleteUser(int id);
    public void deleteUser(User user);
}
