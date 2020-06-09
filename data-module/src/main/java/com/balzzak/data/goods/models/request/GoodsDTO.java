package com.balzzak.data.goods.models.request;

import com.balzzak.data.goods.models.domain.Goods;
import com.balzzak.data.goods.models.domain.GoodsCategory;
import com.balzzak.data.goods.models.domain.GoodsItem;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class GoodsDTO {

    private List<GoodsRequest> goods = new ArrayList<>();
    private List<GoodsCategoryRequest> goodsCategories = new ArrayList<>();
    private List<GoodsItemRequest> goodsItems = new ArrayList<>();

    public List<Goods> convertGoods() {
        List<Goods> list = new ArrayList<>();
        for(GoodsRequest goods : this.goods) {
            // clone 라이브러리를 쓸 수 있긴 하지만.. 성능상 이점을 나중에 확인해 본다
            Goods g = new Goods();
            BeanUtils.copyProperties(goods,g);
            list.add(g);
        }
        return list;
    }

    public List<GoodsCategory> convertGoodsCategory() {
        List<GoodsCategory> list = new ArrayList<>();
        for(GoodsCategoryRequest category : this.goodsCategories) {
            // clone 라이브러리를 쓸 수 있긴 하지만.. 성능상 이점을 나중에 확인해 본다
            GoodsCategory c = new GoodsCategory();
            BeanUtils.copyProperties(category, c);
            list.add(c);
        }
        return list;
    }

    public List<GoodsItem> convertGoodsItem() {
        List<GoodsItem> list = new ArrayList<>();
        for(GoodsItemRequest item : this.goodsItems) {
            // clone 라이브러리를 쓸 수 있긴 하지만.. 성능상 이점을 나중에 확인해 본다
            GoodsItem i = new GoodsItem();
            BeanUtils.copyProperties(item, i);
            list.add(i);
        }
        return list;
    }
}
