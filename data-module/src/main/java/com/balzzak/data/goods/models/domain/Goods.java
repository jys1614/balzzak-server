package com.balzzak.data.goods.models.domain;

import com.balzzak.common.utils.DatetimeHelper;
import com.balzzak.data.goods.models.enums.SaleCode;
import com.balzzak.data.goods.models.enums.SaleState;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Goods {

    //@Builder
    public Goods(int i, String test) {
        this.goodsId = i;
        this.goodsName = test;
    }

    public void setCurrentDatetime() {
        this.createDate = DatetimeHelper.timestampNow();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(Goods goods) {
        this.goodsName = goods.getGoodsName();
        this.regularPrice = goods.getRegularPrice();
        this.description = goods.getDescription();
        this.saleCode = goods.getSaleCode();
        this.saleState = goods.getSaleState();
        this.versionId = goods.getVersionId();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long goodsId;

    @Column(nullable = false)
    private String goodsName;

    @Column(nullable = false)
    private BigDecimal regularPrice;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SaleCode saleCode;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SaleState saleState;

    @Column(nullable = false)
    private long versionId;

    @Column(nullable = false)
    private Timestamp createDate;

    @Column(nullable = false)
    private Timestamp updateDate;

    @OneToMany
    @JoinColumn(name = "goodsId")
    private List<GoodsCategoryMap> categories;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "goodsId", referencedColumnName = "goodsId")
    private GoodsItem goodsItem;
}
