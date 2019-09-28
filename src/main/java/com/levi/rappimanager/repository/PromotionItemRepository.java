package com.levi.rappimanager.repository;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.domain.PromotionItem;
import org.springframework.stereotype.Repository;

@Repository
public interface PromotionItemRepository extends AbstractCrudRepository<PromotionItem> {
}
