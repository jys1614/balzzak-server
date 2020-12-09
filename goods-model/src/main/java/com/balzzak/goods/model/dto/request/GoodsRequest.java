package com.balzzak.goods.model.dto.request;

import com.balzzak.goods.model.enums.SaleCode;
import com.balzzak.goods.model.enums.SaleState;
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
