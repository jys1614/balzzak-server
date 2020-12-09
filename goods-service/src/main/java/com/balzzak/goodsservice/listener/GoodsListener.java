package com.balzzak.goodsservice.listener;

import com.balzzak.goods.message.GoodsMessage;
import com.balzzak.goods.message.GoodsMessageName;
import com.balzzak.goods.model.domain.Goods;
import com.balzzak.goods.model.domain.GoodsCategory;
import com.balzzak.goods.model.dto.request.GoodsDTO;
import com.balzzak.goodsservice.service.GoodsBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GoodsListener {

    private final GoodsBiz goodsBiz;

    public GoodsListener(GoodsBiz goodsBiz) {
        this.goodsBiz = goodsBiz;
    }

    @RabbitListener(queues = "goods.request", containerFactory = "rabbitListenerContainerFactory")
    public Object handleSignUpEvent(final GoodsMessage message) throws Exception {

        GoodsMessageName name = message.getMessageName();
        log.warn(name.name());
        switch(name) {
            case GOODS_GET: {
                Long goodsId = message.deserializeValue(Long.TYPE);
                List<Goods> list = goodsBiz.getGoods(goodsId);
                list.add(new Goods(1,1));
                list.add(new Goods(2,1));
                String response = message.serializeValue(list);
                return response;
            }
            case GOODS_ITEM_GET: {

                break;
            }
            case GOODS_CATEGORY_GET: {
                Long goodsCategoryId = message.deserializeValue(Long.TYPE);
                List<GoodsCategory> list = goodsBiz.getGoodsCategories(goodsCategoryId);
                return message.serializeValue(list);
            }
            case GOODS_SET:{
                GoodsDTO goodsDTO = message.deserializeValue();
                goodsBiz.createGoods(goodsDTO);
                break;
            }
            case GOODS_DEL:{
                long goodsId = message.deserializeValue(long.class);
                goodsBiz.deleteGoods(goodsId);
                break;
            }
            case GOODS_CATEGORY_DEL:{
                long goodsCategoryId = message.deserializeValue(long.class);
                goodsBiz.deleteGoodsCategory(goodsCategoryId);
                break;
            }
            default: {
                log.error("error");
            }
        }
        return null;

        //throw new IllegalArgumentException();
    }
}
