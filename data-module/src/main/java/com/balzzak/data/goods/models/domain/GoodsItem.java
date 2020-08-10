package com.balzzak.data.goods.models.domain;

import com.balzzak.common.utils.DatetimeHelper;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class GoodsItem {

    public void setCurrentDatetime() {
        this.createDate = DatetimeHelper.timestampNow();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(GoodsItem goodsItem) {
        this.goodsId = goodsItem.getGoodsId();
        this.itemSN = goodsItem.getItemSN();
        this.imgPath = goodsItem.getImgPath();
        this.thumbnailPath = goodsItem.getThumbnailPath();
        this.countryOfOrigin = goodsItem.getCountryOfOrigin();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    @Id
    private long goodsId;

    @Column(nullable = false)
    private String itemSN;

    @Column(nullable = false)
    private String imgPath;

    @Column(nullable = false)
    private String thumbnailPath;

    @Column(nullable = false)
    //@Enumerated(EnumType.STRING)
    private String countryOfOrigin;

    @Column(nullable = false)
    private Timestamp createDate;

    @Column(nullable = false)
    private Timestamp updateDate;

}
