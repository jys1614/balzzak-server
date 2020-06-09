package com.balzzak.goodsservice.service;

import com.balzzak.data.goods.interfaces.IGoodsBiz;
import com.balzzak.data.goods.models.domain.Goods;
import com.balzzak.data.goods.models.domain.GoodsCategory;
import com.balzzak.data.goods.models.domain.GoodsCategoryMap;
import com.balzzak.data.goods.models.domain.GoodsItem;
import com.balzzak.data.goods.models.request.GoodsDTO;
import com.balzzak.goodsservice.repository.GoodsCategoryMapRepository;
import com.balzzak.goodsservice.repository.GoodsCategoryRepository;
import com.balzzak.goodsservice.repository.GoodsItemRepository;
import com.balzzak.goodsservice.repository.GoodsRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GoodsBiz implements IGoodsBiz {

    private final GoodsRepository goodsRepository;
    private final GoodsCategoryRepository goodsCategoryRepository;
    private final GoodsItemRepository goodsItemRepository;
    private final GoodsCategoryMapRepository goodsCategoryMapRepository;

    public GoodsBiz(GoodsRepository goodsRepository, GoodsCategoryRepository goodsCategoryRepository, GoodsItemRepository goodsItemRepository, GoodsCategoryMapRepository goodsCategoryMapRepository) {
        this.goodsRepository = goodsRepository;
        this.goodsCategoryRepository = goodsCategoryRepository;
        this.goodsItemRepository = goodsItemRepository;
        this.goodsCategoryMapRepository = goodsCategoryMapRepository;
    }

    // 없는 경우 예외를 보내야 하나??
    public List<Goods> getGoods(Long goodsId) {
        List<Goods> goodsList = new ArrayList<>();
        if(goodsId == null) {
            goodsList = this.goodsRepository.findAll();
        } else {
            Optional<Goods> goods = this.goodsRepository.findById(goodsId);
            if(goods.isPresent() == true)
                goodsList.add(goods.get());
        }
        return goodsList;
    }

    public List<GoodsCategory> getGoodsCategories(Long goodsCategoryId) {
        List<GoodsCategory> categoryList = new ArrayList<>();
        if(goodsCategoryId != null) {
            categoryList = this.goodsCategoryRepository.findAll();
        } else {
            Optional<GoodsCategory> category = this.goodsCategoryRepository.findById(goodsCategoryId);
            if(category.isPresent() == true)
                categoryList.add(category.get());
        }
        return categoryList;
    }

    public void createGoods(GoodsDTO dto) {
        List<Goods> goodsList = dto.convertGoods();
        List<GoodsCategory> categoryList = dto.convertGoodsCategory();
        List<GoodsItem> goodsItemList = dto.convertGoodsItem();

        // SQL 조인으로 하는게 젤 낫겠는데...
        // mysql 에서 TVP 가 지원되는지도 확인 필요

        // goodsRepository.save(dto.getGoods());
        // 카테고리와 아이템도 추가해야 한다면
    }

    public void deleteGoods(long goodsId) {
        // 트랜잭션 처리 필요
        this.goodsCategoryMapRepository.deleteById(new GoodsCategoryMap.MapId(goodsId, null));
        this.goodsRepository.deleteById(goodsId);
    }

    public void deleteGoodsCategory(long goodsCategoryId) {
        this.goodsCategoryMapRepository.deleteById(new GoodsCategoryMap.MapId(null, goodsCategoryId));
        this.goodsCategoryRepository.deleteById(goodsCategoryId);
    }
}
