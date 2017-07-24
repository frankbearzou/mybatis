package com.frankbearzou.mybatis.mapper;

import com.frankbearzou.mybatis.pojo.Orders;

import java.util.List;

public interface OrdersCustomMapper {
    public List<Orders> findOrdersUser();
}
