package com.balzzak.data.goods.models.request;

import com.balzzak.data.goods.models.enums.SaleCode;
import com.balzzak.data.goods.models.enums.SaleState;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
public class GoodsRequest {

    @NotEmpty
    private String goodsName;

    @NotNull
    private BigDecimal regularPrice;

    @NotEmpty
    private String description;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    private SaleCode saleCode;

    @NotNull
    @Enumerated(value = EnumType.ORDINAL)
    private SaleState saleState;

    @NotNull
    private long versionId;

}
