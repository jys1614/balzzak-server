package com.balzzak.data.goods.models.domain;

import com.balzzak.common.utils.DatetimeHelper;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@Entity
public class GoodsCategoryMap {

    public void setCurrentDatetime() {
        this.createDate = DatetimeHelper.timestampNow();
        this.updateDate = DatetimeHelper.timestampNow();
    }

    public void update(long goodsId, long goodsCategoryId) {
        this.id.goodsId = goodsId;
        this.id.goodsCategoryId = goodsCategoryId;
        this.updateDate = DatetimeHelper.timestampNow();
    }

    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class MapId implements Serializable {
        public MapId(Long goodsId, Long goodsCategoryId) {
            this.goodsId = goodsId;
            this.goodsCategoryId = goodsCategoryId;
        }
        private Long goodsId;
        private Long goodsCategoryId;
    }

    @EmbeddedId
    private MapId id;

    @Column(nullable = false)
    private Timestamp createDate;

    @Column(nullable = false)
    private Timestamp updateDate;
}
