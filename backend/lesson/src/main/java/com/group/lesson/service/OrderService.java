package com.group.lesson.service;

import com.group.lesson.entity.Order;

import com.group.lesson.entity.OrderItem;
import com.group.lesson.vo.OrderItemVo;
import com.group.lesson.vo.OrderVo;

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
    Integer getOrderNum(String username);

    /**
     * 下订单
     * @param order
     * @return
     */
    Boolean addOrder(Order order, List<OrderItem> orderItemList);

    /**
     * 查看订单详情
     * @param orderId
     * @return
     */
    List<OrderItemVo> getOrderItem(String orderId);

    /**
     * 根据用户名获取订单
     * @param username pageName
     * @return
     */
    List<OrderVo> getOrderByName(String username, int pageNum);
}
