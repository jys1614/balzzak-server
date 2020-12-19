package com.balzzak.goods.model.domain;

import com.balzzak.goods.model.enums.SaleCode;
import com.balzzak.goods.model.enums.SaleState;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Goods")
@IdClass(GoodsId.class)
public class Goods {

    public void setCurrentDatetime() {
        //this.createDate = DatetimeHelper.timestampNow();
        //this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(Goods goods) {
        this.goodsName = goods.getGoodsName();
        this.regularPrice = goods.getRegularPrice();
        this.description = goods.getDescription();
        this.saleCode = goods.getSaleCode();
        this.saleState = goods.getSaleState();
        this.versionId = goods.getVersionId();
        //this.updateDate = DatetimeHelper.timestampNow();
    }

    @Id
    private long goodsId;

    @Id
    private long categoryId;

    @Column(nullable = false)
    private BigDecimal regularPrice;

    @Column(nullable = false)
    private BigDecimal discountPrice;

    @Column(nullable = false)
    private String goodsName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SaleCode saleCode;

    @Column(nullable = false)
    @Enumerated(EnumType.ORDINAL)
    private SaleState saleState;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private long versionId;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = true)
    private String thumbnailImagePath;

    @Column(nullable = false)
    private String countryOfOrigin;

//    @MapsId("categoryId")
//    @ManyToOne
//    @JoinColumn(name = "categoryId")
    @Transient
    private GoodsCategory category;

//    @OneToMany(fetch = FetchType.LAZY, mappedBy = "goods")
    @Transient
    private List<GoodsPicture> goodsPictures = new ArrayList<>();

}
