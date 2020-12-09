package com.brady.goods.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

/**
 * @description: *
 * @author: brady.si
 * @create: 2020-12-07 22:22
 */
public class GoodsDTO {
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ApiModel("新增商品DTO")
    public static class AddGoodsDTO {

        @ApiModelProperty("商品名")
        @NotNull
        private String goodsName;

        @ApiModelProperty("商品价格")
        @NotNull
        private Double price;

        @ApiModelProperty("详情")
        @NotNull
        private String desc;

        @ApiModelProperty("库存")
        @NotNull
        private Integer inventory;
    }
}
