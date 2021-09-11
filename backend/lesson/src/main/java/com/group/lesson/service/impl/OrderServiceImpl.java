package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.common.TimeUtil;
import com.group.lesson.entity.Order;
import com.group.lesson.entity.OrderItem;
import com.group.lesson.entity.Product;
import com.group.lesson.mapper.OrderItemMapper;
import com.group.lesson.mapper.OrderMapper;
import com.group.lesson.mapper.ProductMapper;
import com.group.lesson.service.OrderService;
import com.group.lesson.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderItemMapper orderItemMapper;
    @Autowired
    private ProductMapper productMapper;

    @Override
    public List<Order> getAllOrder(Integer pageNum) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "userId", "orderTime", "orderTotalPrice", "states");
        queryWrapper.last("limit " + (pageNum - 1) * 10 + ",10");
        List<Order> orders = orderMapper.selectList(queryWrapper);

        return orders;
    }

    @Override
    public Integer getOrderNum() {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        return orderMapper.selectCount(orderQueryWrapper);
    }

    @Override
    public Boolean addOrder(Order order) {
        int insert = orderMapper.insert(order);
        return insert == 1 ? Boolean.TRUE : Boolean.FALSE;
    }

    @Override
    public List<OrderItemVo> getOrderItem(String orderId) {
        QueryWrapper<OrderItem> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("orderId", Integer.valueOf(orderId));
        List<OrderItem> orderItems = orderItemMapper.selectList(queryWrapper);
        ArrayList<OrderItemVo> orderItemVos = new ArrayList<OrderItemVo>();
        for (OrderItem t : orderItems) {
            OrderItemVo orderItemVo = new OrderItemVo();
            orderItemVo.setTotalPrice(t.getTotalPrice());
            orderItemVo.setBeginTime(t.getBeginTime());
            orderItemVo.setEndTime(t.getEndTime());
            orderItemVo.setPrice(t.getPrice());
            Integer day = TimeUtil.twoDaySub(t.getBeginTime(), t.getEndTime());

            orderItemVo.setDays(day);
            Product product = productMapper.selectById(t.getProductId());
            orderItemVo.setProductName(product.getName());
            orderItemVo.setQuantity(t.getQuantity());
            orderItemVos.add(orderItemVo);
        }

        return orderItemVos;
    }


}
