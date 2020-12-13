package com.brady.goods.utils;

import com.brady.goods.entity.Goods;
import com.brady.goods.vo.GoodsVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author brady.si
 */
public class DozerUtils {
    public static List<GoodsVO> getGoodsVOS(List<Goods> goodsList) {
        List<GoodsVO> vos = new ArrayList<>();
        for (Goods goods : goodsList) {
            GoodsVO goodsVO = new GoodsVO();
            goodsVO.setGoodsName(goods.getGoodsName());
            goodsVO.setPrice(goods.getPrice());
            goodsVO.setGoodsDesc(goods.getGoodsDesc());
            goodsVO.setSales(goods.getSales());
            goodsVO.setInventory(goods.getInventory());
            vos.add(goodsVO);
        }
        return vos;
    }
}
