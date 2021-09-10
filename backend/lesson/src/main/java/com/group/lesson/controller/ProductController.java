package com.group.lesson.controller;

import com.group.lesson.common.CommonResult;
import com.group.lesson.entity.Product;
import com.group.lesson.service.ProductService;
import com.group.lesson.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/10 8:47
 */
@RestController
@RequestMapping("/v1/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/getNum")
    public CommonResult<Integer> getNum(){
        return CommonResult.success(productService.getProductNum());

    }
    @RequestMapping("/getPageProduct")
    public CommonResult<List<ProductVo>> getPageProduct(@RequestParam("pageNum") Integer pageNum){
        if (pageNum<=0){
            return CommonResult.fail(new ArrayList<>(),"页数不正确");
        }
        List<ProductVo> pageProduct = productService.getPageProduct(pageNum);
        return CommonResult.success(pageProduct);

    }
}
