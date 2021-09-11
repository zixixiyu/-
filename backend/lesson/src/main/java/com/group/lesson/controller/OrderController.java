package com.group.lesson.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.group.lesson.common.CommonResult;
import com.group.lesson.common.TimeUtil;
import com.group.lesson.entity.Order;
import com.group.lesson.entity.OrderItem;
import com.group.lesson.entity.Product;
import com.group.lesson.entity.User;
import com.group.lesson.mapper.ProductMapper;
import com.group.lesson.mapper.UserMapper;
import com.group.lesson.service.OrderService;

import com.group.lesson.vo.OrderItemVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author ASUS
 */
@RestController
@RequestMapping("/v1/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ProductMapper productMapper;

    @RequestMapping(value = "/getOrderNum")
    public CommonResult<Integer> getOrderNum(){
        Integer orderNum = orderService.getOrderNum();
        return CommonResult.success(orderNum);

    }
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
        String productId = jsonObject.getString("productId");
        String beginTime = jsonObject.getString("beginTime");
        String endTime = jsonObject.getString("endTime");
        String productNum = jsonObject.getString("productNum");
        if (!StringUtils.hasText(productId)||!StringUtils.hasText(beginTime)||!StringUtils.hasText(endTime)||!StringUtils.hasText(productNum)){
            return CommonResult.fail(Boolean.FALSE,"参数不能空");
        }
        Boolean pd = false;
        try {
            int productNumI = Integer.parseInt(productNum);
            if (productNumI<=0){
                return CommonResult.fail(Boolean.FALSE,"参数错误");
            }
            int productIdI = Integer.parseInt(productId);
            SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            //UTC是本地时间，拼串 6+
            beginTime= beginTime.replace("Z", "");
            endTime = endTime.replace("Z","");
            beginTime = beginTime.replace("T", " ");
            endTime = endTime.replace("T"," ");
            System.out.println(beginTime);
            System.out.println(endTime);
            Date a = null;
            Date b = null;
            try {
                a = formatter.parse(beginTime);
                b = formatter.parse(endTime);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            System.out.println(a);
            System.out.println(b);

            Random random = new Random();
            int i = random.nextInt(999999999);
            Order order = new Order();
            order.setId(i);
            order.setOrderTime(new Date());
            String header = httpServletRequest.getHeader("u-token");
            String username = redisTemplate.opsForValue().get(header);
            QueryWrapper<User> wrapper = new QueryWrapper<>();
            wrapper.eq("username",username);
            List<User> users = userMapper.selectList(wrapper);
            if (users.size()!=1){
                return CommonResult.fail(Boolean.FALSE,"账号有问题");
            }
            order.setUserId(users.get(0).getId());

            OrderItem orderItem = new OrderItem();
            orderItem.setBeginTime(a);
            orderItem.setEndTime(b);
            orderItem.setOrderId(i);

            Product product = productMapper.selectById(productIdI);

            orderItem.setPrice(product.getDiscountDailyPrice());
            orderItem.setProductId(productIdI);
            orderItem.setQuantity(productNumI);
            //订单项价格
            double totalPrice = orderItem.getPrice()*TimeUtil.twoDaySub(a,b)*productNumI+product.getDeposit()*productNumI;
            orderItem.setTotalPrice(totalPrice);
            ArrayList<OrderItem> orderItems = new ArrayList<>();
            orderItems.add(orderItem);
            pd = orderService.addOrder(order, orderItems);

        }catch (Exception e){
                e.printStackTrace();
                return CommonResult.fail(Boolean.FALSE,"运行出错");
        }
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
        if ("".equals(orderId)){
            return CommonResult.fail(new ArrayList<OrderItemVo>(),"查看失败");
        }
        List<OrderItemVo> orderItemVos = orderService.getOrderItem(orderId);


        return CommonResult.success(orderItemVos);
    }
}
