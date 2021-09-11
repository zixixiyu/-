package com.group.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.lesson.common.CommonResult;
import com.group.lesson.entity.Order;
import com.group.lesson.entity.OrderItem;
import com.group.lesson.service.OrderService;

import com.group.lesson.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/getAllOrder",method = RequestMethod.GET)
    public CommonResult<List<Order>> get(
            @RequestParam("pageNum") int pageNum
    ){
        if (pageNum<=0){
            return CommonResult.fail(new ArrayList<Order>(),"查询不正确");
        }
        List<Order> allOrder = orderService.getAllOrder(pageNum);


        return CommonResult.success(allOrder);
    }


    @RequestMapping(value = "/addOrder",method = RequestMethod.POST)
    public CommonResult<Boolean> addOrder(
            @RequestBody String jsonString
    ){
        JSONObject jsonObject = JSON.parseObject(jsonString);
        String userId = jsonObject.getString("userId");
        String orderTotalPrice = jsonObject.getString("orderTotalPrice");

        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date orderTime = new Date(System.currentTimeMillis());

        Order order = new Order();
        order.setUserId(Integer.valueOf(userId));
        order.setOrderTime(orderTime);
        order.setOrderTotalPrice(Double.valueOf(orderTotalPrice));

        Boolean pd = orderService.addOrder(order);
        if(pd){
            return CommonResult.success(Boolean.TRUE);

        }else{
            return CommonResult.fail(Boolean.FALSE,"下单失败");
        }

    }

    @RequestMapping(value = "/getOrderItem",method = RequestMethod.GET)
    public CommonResult<List<OrderItemVo>>get(
            @RequestParam("orderId") String orderId
    ){
        if (" ".equals(orderId)){
            return CommonResult.fail(new ArrayList<OrderItemVo>(),"查看失败");
        }
        List<OrderItemVo> orderItemVos = orderService.getOrderItem(orderId);


        return CommonResult.success(orderItemVos);
    }
}
