package com.frankbearzou.mybatis;


import com.frankbearzou.mybatis.dao.UserDAO;
import com.frankbearzou.mybatis.dao.impl.UserDAOImpl;
import com.frankbearzou.mybatis.pojo.User;

import java.util.List;

public class App
{
    public static void main( String[] args )
    {
        UserDAO userDAO = new UserDAOImpl();

//        Calendar calendar = Calendar.getInstance();
//        calendar.set(2015, 10, 13);
//
//        User user = new User("Timothy", "1", calendar.getTime(), "410 Campbell Ave");
//        userDAO.addUser(user);
//        System.out.println("new user id: " + user.getId());

//        User user = userDAO.getUserById(1);
        List<User> users = userDAO.findUserByName("Timothy");
        System.out.println(users);

//        User user = userDAO.getUserById(2);
//        System.out.println(user);
//        user.setUsername("Goodman");
//        userDAO.updateUser(user);
//        System.out.println(user);
//
//        userDAO.deleteUser(user);

    }

}
