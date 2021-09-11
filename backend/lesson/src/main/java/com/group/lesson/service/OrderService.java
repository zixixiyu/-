package com.group.lesson.service;

import com.group.lesson.entity.Order;

import com.group.lesson.vo.OrderItemVo;

import java.util.List;

public interface OrderService {

    /**
     * 分页获取订单
     * @param pageNum
     * @return
     */
    List<Order> getAllOrder(Integer pageNum);

    /**
     * 获取订单总数量
     * @return
     */
    Integer getOrderNum();

    /**
     * 下订单
     * @param order
     * @return
     */
    Boolean addOrder(Order order);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItemVo> getOrderItem(String orderId);


}
