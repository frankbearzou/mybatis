package com.frankbearzou.mybatis.mapper;

import com.frankbearzou.mybatis.pojo.Orders;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class OrdersCustomMapperTest {
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
    public void testFindOrdersUser() {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        try {
            OrdersCustomMapper mapper = sqlSession.getMapper(OrdersCustomMapper.class);
            List<Orders> orders = mapper.findOrdersUser();
            System.out.println(orders);
            assertTrue(orders.size() > 0);
        } finally {
            sqlSession.close();
        }
    }
}
