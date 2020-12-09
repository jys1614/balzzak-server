package com.balzzak.goods.model.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "GoodsPicture")
@IdClass(GoodsPictureId.class)
public class GoodsPicture {

    public GoodsPicture(long pictureId, long goodsId) {
        this.pictureId = pictureId;
        this.goodsId = goodsId;
    }

    @Id
    private long pictureId;

    @Id
    private long goodsId;

    @Column(nullable = false)
    private String picturePath;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;

//    @MapsId("goodsId")
//    @ManyToOne
//    @JoinColumns({
//            @JoinColumn(name = "goodsId"),
//            @JoinColumn(name = "categoryId"),
//    })
    @Transient
    private Goods goods;
}
