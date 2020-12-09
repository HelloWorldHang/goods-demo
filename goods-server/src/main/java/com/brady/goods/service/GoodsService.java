package com.brady.goods.service;

import com.brady.goods.dto.GoodsDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author lenovo
 */
@Service
public interface GoodsService {

    /**
     * 增加商品
     * @param reqDto
     * @return 主键
     */
    int addGoods(GoodsDTO.AddGoodsDTO reqDto);
    
}
