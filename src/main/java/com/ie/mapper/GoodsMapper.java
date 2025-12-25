package com.ie.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ie.entity.Goods;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface GoodsMapper extends BaseMapper<Goods> {
    // 无需手动写SQL，MyBatis Plus提供CRUD默认实现
}