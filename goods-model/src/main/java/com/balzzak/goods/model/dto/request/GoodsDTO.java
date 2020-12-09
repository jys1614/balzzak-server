package com.balzzak.goods.model.dto.request;

import com.balzzak.goods.model.domain.Goods;
import com.balzzak.goods.model.domain.GoodsCategory;
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

}
