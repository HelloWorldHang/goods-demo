package com.brady.goods.controller;

import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.export.GoodsApi;
import com.brady.goods.service.GoodsService;
import com.brady.goods.vo.GoodsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author brady.si
 */
@RestController
public class GoodsController implements GoodsApi {
    @Autowired
    GoodsService goodsService;
    @Override
    public Integer addGoods(@Validated @RequestBody GoodsDTO.AddGoodsDTO dto) {
        return goodsService.addGoods(dto);
    }

    @Override
    public List<GoodsVO> queryGoods() {
        return goodsService.queryGoods();
    }

    @Override
    public Integer updateGoods(@Validated @RequestBody GoodsDTO.UpdateGoodsDTO dto) {
        return goodsService.updateGoods(dto);
    }

    @Override
    public Integer queryGoods(Integer id) {
        return goodsService.deleteGoods(id);
    }
}
