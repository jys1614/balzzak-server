package com.balzzak.goodsservice.listener;

import com.balzzak.goods.message.GoodsMessage;
import com.balzzak.goods.message.GoodsMessageName;
import com.balzzak.goods.model.domain.Goods;
import com.balzzak.goods.model.domain.GoodsCategory;
import com.balzzak.goods.model.dto.request.GoodsDTO;
import com.balzzak.goodsservice.repository.*;
import com.balzzak.goodsservice.service.GoodsBiz;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class GoodsListener {

    private final GoodsBiz goodsBiz;
    private final GoodsRepository goodsRepository;
    private final GoodsCategoryRepository goodsCategoryRepository;
    private final GoodsSetRepository goodsSetRepository;
    private final GoodsPictureRepository goodsPictureRepository;
    private final GoodsVersionRepository goodsVersionRepository;

    public GoodsListener(GoodsBiz goodsBiz, GoodsRepository goodsRepository, GoodsCategoryRepository goodsCategoryRepository, GoodsSetRepository goodsSetRepository, GoodsPictureRepository goodsPictureRepository, GoodsVersionRepository goodsVersionRepository) {
        this.goodsBiz = goodsBiz;
        this.goodsRepository = goodsRepository;
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.goodsSetRepository = goodsSetRepository;
        this.goodsPictureRepository = goodsPictureRepository;
        this.goodsVersionRepository = goodsVersionRepository;
    }

    @RabbitListener(queues = "goods.request", containerFactory = "rabbitListenerContainerFactory")
    public Object handleSignUpEvent(final GoodsMessage message) throws Exception {

        try {
            GoodsMessageName name = message.getMessageName();
            log.warn(name.name());
            switch(name) {
                case GOODS_GET: {
                    Long goodsId = message.deserializeValue(Long.TYPE);
                    List<Goods> list = goodsBiz.getGoods(goodsId, null);

                    String response = message.serializeValue(list);
                    return response;
                }
                case GOODS_CATEGORY_GET: {
                    Long goodsCategoryId = message.deserializeValue(Long.TYPE);
                    List<Goods> list = goodsBiz.getGoods(null, goodsCategoryId);
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
                case CATEGORY_DEL:{
                    long goodsCategoryId = message.deserializeValue(long.class);
                    goodsBiz.deleteGoodsCategory(goodsCategoryId);
                    break;
                }
                default: {
                    log.error("error");
                }
            }

        } catch (Exception ex) {

        }
        return new RuntimeException("runtime");
    }
}
