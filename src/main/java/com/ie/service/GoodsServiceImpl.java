package com.ie.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ie.entity.Goods;
import com.ie.mapper.GoodsMapper;
import com.ie.service.GoodsService;
import org.springframework.stereotype.Service;

@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {
}