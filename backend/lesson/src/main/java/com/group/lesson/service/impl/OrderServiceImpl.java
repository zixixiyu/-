package com.group.lesson.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.common.TimeUtil;
import com.group.lesson.entity.Order;
import com.group.lesson.entity.OrderItem;
import com.group.lesson.entity.Product;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.OrderItemMapper;
import com.group.lesson.mapper.OrderMapper;
import com.group.lesson.mapper.ProductMapper;
import com.group.lesson.mapper.UserMapper;
import com.group.lesson.service.OrderService;
import com.group.lesson.vo.OrderItemVo;
import com.group.lesson.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Order> getAllOrder(Integer pageNum) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "userId", "orderTime", "orderTotalPrice", "states");
        queryWrapper.last("limit " + (pageNum - 1) * 10 + ",10");
        List<Order> orders = orderMapper.selectList(queryWrapper);
        return orders;
    }


    @Override
    public Boolean addOrder(Order order,List<OrderItem> orderItemList) {
        Double sum = 0.0;
        for (OrderItem o :
                orderItemList) {
            sum = o.getTotalPrice();
            orderItemMapper.insert(o);
        }
        order.setOrderTotalPrice(sum);
        int i = orderMapper.insert(order);
        return i==1?Boolean.TRUE:Boolean.FALSE;
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

    @Override
    public List<OrderVo> getOrderByName(String username, int pageNum) {
        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "userId", "orderTime", "orderTotalPrice");
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> users = userMapper.selectList(wrapper);
        if (users.size()!=1){
            return new ArrayList<>();
        }
        queryWrapper.eq("userId",users.get(0).getId());
        queryWrapper.last("limit " + (pageNum - 1) * 5 + ",5");
        List<Order> orders = orderMapper.selectList(queryWrapper);
        ArrayList<OrderVo> orderVos = new ArrayList<>();
        for (Order o :orders) {
            OrderVo orderVo = new OrderVo();
            orderVo.setId(o.getId());
            orderVo.setOrderTime(o.getOrderTime());
            orderVo.setUsername(username);
            orderVo.setOrderTotalPrice(o.getOrderTotalPrice());
            orderVos.add(orderVo);
        }
        return orderVos;
    }

    @Override
    public Integer getOrderNum(String username) {
        QueryWrapper<Order> orderQueryWrapper = new QueryWrapper<>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        List<User> users = userMapper.selectList(wrapper);
        if (users.size()!=1){
            return -1;
        }
        orderQueryWrapper.eq("userId",users.get(0).getId());
        return orderMapper.selectCount(orderQueryWrapper);
    }
}
