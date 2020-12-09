package com.balzzak.goodsservice.repository;

import com.balzzak.goods.model.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, GoodsId> {
}
