package com.levi.rappimanager.service;

import com.levi.rappimanager.crud.AbstractCrudRepository;
import com.levi.rappimanager.crud.AbstractCrudService;
import com.levi.rappimanager.domain.PromotionItem;
import org.springframework.stereotype.Service;

@Service
public class PromotionItemService extends AbstractCrudService<PromotionItem> {

    public PromotionItemService(AbstractCrudRepository<PromotionItem> repository) {
        super(repository);
    }

}
