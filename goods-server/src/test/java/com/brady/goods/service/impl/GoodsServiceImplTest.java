package com.brady.goods.service.impl;

import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.service.GoodsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class GoodsServiceImplTest {
    @Autowired
    GoodsService goodsService;

    @Test
    void addGoods() {
        GoodsDTO.AddGoodsDTO goodsDTO = GoodsDTO.AddGoodsDTO.builder().goodsName("火腿肠").price(5.5).desc("好吃的很").inventory(100).build();
        int res = goodsService.addGoods(goodsDTO);
        System.out.println(res + "-----------------------------");
    }
}