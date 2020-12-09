package com.balzzak.goods.contract.operation;

import com.balzzak.goods.model.domain.Goods;

import java.util.List;

public interface IGoodsBiz {
    List<Goods> getGoods(Long goodsId);
}
