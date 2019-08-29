package cn.txh.service;

import cn.txh.domain.Orders;

import java.util.List;

public interface IOrdersService{
    /**
     * 订单查询所有的方法
     * @return
     * @throws Exception
     */
    List<Orders> findAll(int page,int size) throws Exception;

    /**
     * 订单详情的方法
     * @param ordersId
     * @return
     */
    Orders findById(String ordersId) throws Exception;
}
