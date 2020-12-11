package com.brady.goods.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

/**
 * @author brady.si
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "商品VO")
public class GoodsVO {
    @ApiModelProperty("商品名")
    private String goodsName;

    @ApiModelProperty("商品价格")
    private Double price;

    @ApiModelProperty("详情")
    private String goodsDesc;

    @ApiModelProperty("销量")
    private Integer sales;

    @ApiModelProperty("库存")
    private Integer inventory;
}
