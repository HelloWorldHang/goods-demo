package com.brady.goods.export;

import com.brady.goods.ServiceNameConst;
import com.brady.goods.dto.GoodsDTO;
import com.brady.goods.vo.GoodsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE;

/**
 * @author brady.si
 */
@FeignClient(ServiceNameConst.SERVICE_NAME)
@Api("商品api")
public interface GoodsApi {
    /**
     * 增加商品
     *
     * @param dto 接口入参
     * @return Integer
     */
    @ApiOperation(value = "增加商品", response = Integer.class)
    @PostMapping(value = "/goods/addGoods", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    Integer addGoods(@Validated @RequestBody GoodsDTO.AddGoodsDTO dto);

    /**
     * 查询商品
     *
     * @param
     * @return Integer
     */
    @ApiOperation(value = "查询商品", response = GoodsVO.class)
    @PostMapping(value = "/goods/queryGoods", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    List<GoodsVO> queryGoods();

    /**
     * 增加商品
     *
     * @param dto 接口入参
     * @return Integer
     */
    @ApiOperation(value = "更新商品", response = Integer.class)
    @PostMapping(value = "/goods/updateGoods", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    Integer updateGoods(@Validated @RequestBody GoodsDTO.UpdateGoodsDTO dto);

    /**
     * 删除商品
     *
     * @param id
     * @return Integer
     */
    @ApiOperation(value = "删除商品", response = Integer.class)
    @PostMapping(value = "/goods/deleteGoods", produces = APPLICATION_JSON_UTF8_VALUE, consumes = APPLICATION_JSON_UTF8_VALUE)
    Integer queryGoods(Integer id);
}
