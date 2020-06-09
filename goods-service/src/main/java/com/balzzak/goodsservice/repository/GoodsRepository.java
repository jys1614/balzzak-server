package com.balzzak.goodsservice.repository;

import com.balzzak.data.goods.models.domain.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Long> {
}
