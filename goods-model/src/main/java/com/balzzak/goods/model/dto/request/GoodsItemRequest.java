package com.balzzak.goods.model.dto.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;

@Getter
public class GoodsItemRequest {

    @NotEmpty
    private String itemSN;

    @NotEmpty
    private String imgPath;

    @NotEmpty
    private String thumbnailPath;

    @NotEmpty
    private String countryOfOrigin;
}
