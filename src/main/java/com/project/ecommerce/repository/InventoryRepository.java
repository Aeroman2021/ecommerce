package com.project.ecommerce.repository;

import com.project.ecommerce.model.entity.Inventory;
import com.project.ecommerce.model.entity.enums.InventoryStatus;
import com.project.ecommerce.repository.base.BaseRepository;

public interface InventoryRepository extends BaseRepository<Inventory,Integer> {

    Long countInventoriesByCardIdAndStatus(int CardId, InventoryStatus status);
}
