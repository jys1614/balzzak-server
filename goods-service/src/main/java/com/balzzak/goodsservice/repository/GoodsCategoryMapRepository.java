package com.balzzak.goodsservice.repository;

import com.balzzak.data.goods.models.domain.GoodsCategoryMap;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoodsCategoryMapRepository extends JpaRepository<GoodsCategoryMap, GoodsCategoryMap.MapId> {
}
