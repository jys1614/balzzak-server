package com.balzzak.goods.model.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "GoodsSet")
@IdClass(GoodsSetId.class)
public class GoodsSet {

    @Id
    private long setGoodsId;

    @Id
    private long goodsId;

    @Column(nullable = false)
    private LocalDateTime createDate;

    @Column(nullable = false)
    private LocalDateTime updateDate;
}
