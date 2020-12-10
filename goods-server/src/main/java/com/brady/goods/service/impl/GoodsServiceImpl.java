package com.brady.goods.service.impl;

import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.entity.Goods;
import com.brady.goods.mapper.GoodsMapper;
import com.brady.goods.service.GoodsService;
import com.brady.goods.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @description:
 * @author: brady.si
 * @create: 2020-12-07 22:54
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    GoodsMapper goodsMapper;
    @Override
    public int addGoods(GoodsDTO.AddGoodsDTO reqDto) {
        Goods goods = new Goods();
        goods.setGoodsName(reqDto.getGoodsName());
        goods.setPrice(reqDto.getPrice());
        goods.setDesc(reqDto.getDesc());
        goods.setInventory(reqDto.getInventory());
        goods.setCreateTime(DateUtil.getCurrentSeconds());
        return goodsMapper.insert(goods);
    }
}
