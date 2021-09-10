package com.group.lesson.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.lesson.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: hwj
 * @Date: 2021/9/10 10:17
 */
@Mapper
public interface ProductVoMapper extends BaseMapper<ProductVo> {
    /**
     * 获取分页
     * @param pageNum
     * @return
     */
    List<ProductVo> getPageNum(Integer pageNum);
}
