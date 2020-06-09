package com.balzzak.data.goods.models.request;

import lombok.Getter;

@Getter
public class GoodsItemRequest {

    private String itemSN;

    private String imgPath;

    private String thumbnailPath;

    private String countryOfOrigin;
}
