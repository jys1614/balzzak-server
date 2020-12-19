package com.balzzak.goods.model.domain;

import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;


@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
public class GoodsId  implements Serializable {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long goodsId;

    @EqualsAndHashCode.Include
    @Id
    private long categoryId;

    public GoodsId(long goodsId, long categoryId) {
        this.goodsId = goodsId;
        this.categoryId = categoryId;
    }

}
