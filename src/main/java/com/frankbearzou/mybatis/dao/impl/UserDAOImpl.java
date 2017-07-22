package com.frankbearzou.mybatis.dao.impl;

import com.frankbearzou.mybatis.User;
import com.frankbearzou.mybatis.dao.UserDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private SqlSessionFactory sqlSessionFactory = null;
    private SqlSession sqlSession = null;

    public UserDAOImpl() {
        init();
    }

    private void init() {
        String resource = "mybatis-config.xml";
        InputStream inputStream = null;
        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

    }

    public User findUserById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            User user = sqlSession.selectOne("com.frankbearzou.mybatis.mapper.UserMapper.findUserById", id);
            return user;
        } finally {
            sqlSession.close();
        }
    }

    public List<User> findUserByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            List<User> users = sqlSession.selectList("com.frankbearzou.mybatis.mapper.UserMapper.findUserByName", name);
            return users;
        } finally {
            sqlSession.close();
        }
    }

    public void addUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.insert("com.frankbearzou.mybatis.mapper.UserMapper.insertUser", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void updateUser(User user) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.update("com.frankbearzou.mybatis.mapper.UserMapper.updateUser", user);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteUser(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            sqlSession.delete("com.frankbearzou.mybatis.mapper.UserMapper.deleteUser", id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
        }
    }

    public void deleteUser(User user) {
        deleteUser(user.getId());
    }

}
