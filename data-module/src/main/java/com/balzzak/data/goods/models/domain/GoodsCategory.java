package com.balzzak.data.goods.models.domain;

import com.balzzak.common.utils.DatetimeHelper;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Currency;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class GoodsCategory {

    public void setCurrentDatetime() {
        this.createDate = DatetimeHelper.timestampNow();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(GoodsCategory goodsCategory) {
        this.sortOrder = goodsCategory.getSortOrder();
        this.upperCategoryId = goodsCategory.getUpperCategoryId();
        this.categoryName = goodsCategory.getCategoryName();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    @Builder
    public GoodsCategory(long categoryId, String categoryName, Timestamp createDate, Timestamp updateDate) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.createDate = createDate;
        this.updateDate = updateDate;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long categoryId;

    @Column(nullable = false)
    private int sortOrder;

    @Column(nullable = false)
    private long upperCategoryId;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private Timestamp createDate;

    @Column(nullable = false)
    private Timestamp updateDate;

    @OneToMany
    @JoinColumn(name = "goodsCategoryId")
    private List<GoodsCategoryMap> goods;
}
