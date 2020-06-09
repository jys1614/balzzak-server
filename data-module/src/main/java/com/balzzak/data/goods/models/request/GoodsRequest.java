package com.balzzak.data.goods.models.request;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class GoodsRequest {

    private String goodsName;

    private BigDecimal regularPrice;

    private String description;

    private int saleCode;

    private int saleState;

    private long versionId;
}
