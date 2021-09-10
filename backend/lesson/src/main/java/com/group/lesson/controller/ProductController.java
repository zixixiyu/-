package com.group.lesson.controller;

import com.group.lesson.common.CommonResult;
import com.group.lesson.entity.Product;
import com.group.lesson.service.ProductService;
import com.group.lesson.vo.ProductVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
    @RequestMapping("/shanxiajia")
    public CommonResult<Boolean> shxiajia(@RequestParam("productName") String productName){
        if (!StringUtils.hasText(productName)){
            return CommonResult.fail(Boolean.FALSE,"商品名称为空");
        }
        boolean shxjia = productService.shxjia(productName);
        if (shxjia){
            return CommonResult.success(Boolean.TRUE);
        }else {

            return CommonResult.fail(Boolean.FALSE,"上下架失败");
        }

    }
    @RequestMapping(value = "/insertProduct",method = RequestMethod.POST)
    public CommonResult<Boolean> insertProduct(
            @RequestParam("pic") MultipartFile file,@RequestParam Map<String, String> postInfo
    ) throws IOException {
        if (file==null||postInfo.isEmpty()){
            return CommonResult.fail(Boolean.FALSE,"参数不可以为空");
        }
        File fileDir = new File("F:\\lessonDesign\\backend\\lesson\\src\\main\\resources\\static");
        if(!fileDir.exists()) {
            //如果没有目录应该创建目录
            fileDir.mkdirs();
        }
        //获取图片名称
        String imgName = file.getOriginalFilename();
        String path = "F:\\lessonDesign\\backend\\lesson\\src\\main\\resources\\static\\"+imgName;
        //文件实现上传
        file.transferTo(new File(path));

        boolean b = productService.insertProduct(postInfo, imgName);
        if (b){
            return CommonResult.success(Boolean.TRUE);
        }
        return CommonResult.fail(Boolean.FALSE,"插入数据失败");

    }
}
