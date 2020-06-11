package com.balzzak.data.goods.models.request;

import lombok.Getter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
public class GoodsCategoryRequest {

    @NotNull
    private Integer sortOrder;

    @NotEmpty
    private String categoryName;
}
