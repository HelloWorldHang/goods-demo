package com.brady.goods.service.impl;

import com.brady.goods.BaseApplication;
import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.service.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
public class GoodsServiceImplTest extends BaseApplication {
    @Autowired
    GoodsService goodsService;

    @Test
    public void addGoods() {
        GoodsDTO.AddGoodsDTO goodsDTO = GoodsDTO.AddGoodsDTO.builder().goodsName("火腿肠").price(5.5).desc("好吃的很").inventory(100).build();
        int res = goodsService.addGoods(goodsDTO);
        System.out.println(res + "-----------------------------");
    }
}