package com.balzzak.data.goods.interfaces;

import com.balzzak.data.goods.models.domain.Goods;

import java.util.List;

public interface IGoodsBiz {
    List<Goods> getGoods(Long goodsId);
}
