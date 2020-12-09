package com.balzzak.gatewayservice.controller;

import com.balzzak.goods.message.GoodsMessage;
import com.balzzak.goods.message.GoodsMessageName;


import com.balzzak.common.template.BalzzakRabbitTemplate;
import com.balzzak.goods.model.domain.Goods;
import com.balzzak.goods.model.domain.GoodsCategory;
import com.balzzak.goods.model.dto.request.GoodsDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/goods")
@RestController
public class GoodsController {

    private final BalzzakRabbitTemplate amqpTemplate;

    public GoodsController(BalzzakRabbitTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @GetMapping(path = "/{goodsId}")
    public List<Goods> getGoods(@PathVariable long goodsId) {
        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_GET, goodsId);
        List<Goods>  response = amqpTemplate.SendMessageAndReceive(message);

        return response;
    }

//    @GetMapping(path = "/items/{goodsItemId}")
//    public List<GoodsItem> getGoodsItems(@PathVariable long goodsItemId) {
//        // 테이블을 하나로 합칠지 정할 것
//        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_ITEM_GET, goodsItemId);
//        List<GoodsItem> response = amqpTemplate.SendMessageAndReceive(message);
//        return response;
//    }

    @GetMapping(path = "/categories/{goodsCategoryId}")
    public List<GoodsCategory> getGoodsCategories(@PathVariable long goodsCategoryId) {
        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_CATEGORY_GET, goodsCategoryId);
        List<GoodsCategory> response = amqpTemplate.SendMessageAndReceive(message);
        return response;
    }

    @PostMapping(path = "")
    public ResponseEntity createGoods(@Valid @RequestBody GoodsDTO req) {

        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_SET, req);
        amqpTemplate.SendMessageAndReceiveAck(message);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand("여기에 넣을 Id는? 버전Id?")
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping(path = "/{goodsId}")
    public ResponseEntity deleteGoods(@PathVariable long goodsId) {

        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_DEL, goodsId);
        amqpTemplate.SendMessageAndReceiveAck(message);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(path = "/categories/{goodsCategoryId}")
    public ResponseEntity deleteGoodsCategory(@PathVariable long goodsCategoryId) {
        GoodsMessage message = new GoodsMessage(GoodsMessageName.GOODS_CATEGORY_DEL, goodsCategoryId);
        amqpTemplate.SendMessageAndReceiveAck(message);
        return ResponseEntity.noContent().build();
    }


}
