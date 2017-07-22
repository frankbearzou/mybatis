package com.frankbearzou.mybatis.dao.impl;


import com.frankbearzou.mybatis.User;
import com.frankbearzou.mybatis.dao.UserDAO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UserDAOImplTest {
    private UserDAO userDAO = null;

    @Before
    public void setUp() {
        userDAO = new UserDAOImpl();
    }

    @Test
    public void testFindUserById() {
        User user = userDAO.findUserById(1);
        System.out.println(user);
        assertEquals(1, user.getId());
    }

}
