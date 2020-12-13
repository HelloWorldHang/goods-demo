package com.brady.goods.service;

import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.entity.Goods;
import com.brady.goods.vo.GoodsVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author lenovo
 */
public interface GoodsService {

    /**
     * 增加商品
     * @param reqDto
     * @return 主键
     */
    int addGoods(GoodsDTO.AddGoodsDTO reqDto);

    /**
     * 查询所有商品
     * @return
     */
    List<GoodsVO> queryGoods();

    /**
     * 根据商品名模糊查询
     * @param dto
     * @return goodsVO
     */
    List<GoodsVO> queryGoodsByExample(GoodsDTO.QueryGoodsDTO dto);

    /**
     * 更新商品
     * @param dto
     * @return
     */
    Integer updateGoods(GoodsDTO.UpdateGoodsDTO dto);

    /**
     * 删除商品
     * @param id
     * @return
     */
    Integer deleteGoods(Integer id);

}
