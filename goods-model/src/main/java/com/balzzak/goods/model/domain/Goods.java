package com.balzzak.goods.model.domain;

<<<<<<< HEAD
<<<<<<<< HEAD:goods-model/src/main/java/com/balzzak/goods/model/domain/Goods.java
import com.balzzak.goods.model.enums.SaleCode;
import com.balzzak.goods.model.enums.SaleState;
========
import com.balzzak.common.utils.DatetimeHelper;
import com.balzzak.data.goods.models.enums.SaleCode;
import com.balzzak.data.goods.models.enums.SaleState;
import lombok.Builder;
import lombok.EqualsAndHashCode;
>>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03:data-module/src/main/java/com/balzzak/data/goods/models/domain/Goods.java
=======
import com.balzzak.common.utils.DatetimeHelper;
import com.balzzak.goods.model.enums.SaleCode;
import com.balzzak.goods.model.enums.SaleState;
import lombok.Builder;
import lombok.EqualsAndHashCode;
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
<<<<<<< HEAD
<<<<<<<< HEAD:goods-model/src/main/java/com/balzzak/goods/model/domain/Goods.java
========
import java.sql.Timestamp;
>>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03:data-module/src/main/java/com/balzzak/data/goods/models/domain/Goods.java
=======
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "Goods")
@IdClass(GoodsId.class)
public class Goods {

<<<<<<< HEAD
<<<<<<<< HEAD:goods-model/src/main/java/com/balzzak/goods/model/domain/Goods.java
========
=======
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03
    public Goods(long goodsId, long categoryId) {
        this.goodsId = goodsId;
        this.categoryId = categoryId;
    }

<<<<<<< HEAD
>>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03:data-module/src/main/java/com/balzzak/data/goods/models/domain/Goods.java
=======
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03
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
<<<<<<< HEAD
<<<<<<<< HEAD:goods-model/src/main/java/com/balzzak/goods/model/domain/Goods.java

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private long versionId;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = true)
    private String thumbnailImagePath;

    @Column(nullable = false)
========
=======
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03

    @Column(nullable = false)
    private LocalDateTime updateDate;

    @Column(nullable = false)
    private long versionId;

    @Column(nullable = true)
    private String imagePath;

    @Column(nullable = true)
    private String thumbnailImagePath;

    @Column(nullable = false)
<<<<<<< HEAD
>>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03:data-module/src/main/java/com/balzzak/data/goods/models/domain/Goods.java
=======
>>>>>>> 4f7cbbb72fc81313a80a8b27a63286eb61b96d03
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
