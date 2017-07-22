package com.frankbearzou.mybatis.mapper;

import com.frankbearzou.mybatis.User;
import com.frankbearzou.mybatis.UserCustom;
import com.frankbearzou.mybatis.UserVO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserMapperTest {
    private SqlSessionFactory sqlSessionFactory = null;

    @Before
    public void setUp() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


    }

    @Test
    public void testFindUserById() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            User user = userMapper.findUserById(1);
            assertEquals(1, user.getId());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindUserCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setSex("1");
            UserVO userVO = new UserVO(user);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            int userCount = userMapper.findUserCount(userVO);
            System.out.println(userCount);
            assertTrue(userCount > 0);
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testFindUserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = new User();
            user.setSex("1");
            UserVO userVO = new UserVO(user);

            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            List<UserCustom> userCustoms = userMapper.findUserList(userVO);
            System.out.println(userCustoms);
            assertTrue(userCustoms.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
}
