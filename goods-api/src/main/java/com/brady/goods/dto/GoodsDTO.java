package com.brady.goods.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
        private String goodsDesc;

        @ApiModelProperty("库存")
        @NotNull
        private Integer inventory;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ApiModel("更新商品DTO")
    public static class UpdateGoodsDTO {
        @ApiModelProperty("id")
        @NotNull
        private Integer id;

        @ApiModelProperty("商品名")
        private String goodsName;

        @ApiModelProperty("商品价格")
        private Double price;

        @ApiModelProperty("详情")
        private String goodsDesc;

        @ApiModelProperty("库存")
        private Integer inventory;
    }


    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @ApiModel("查询商品通用DTO")
    public static class QueryGoodsDTO {

        @ApiModelProperty("商品名")
        @NotNull
        @Size(min = 1, max = 32)
        private String goodsName;

        @ApiModelProperty("商品价格下限")
        private Double lowPrice;

        @ApiModelProperty("商品价格上限")
        private Double highPrice;

        @ApiModelProperty("详情")
        private String goodsDesc;
    }
}
