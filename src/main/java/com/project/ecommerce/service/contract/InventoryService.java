package com.project.ecommerce.service.contract;


import com.project.ecommerce.model.Dto.InventoryDto;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {

    InventoryDto createOrUpdate(InventoryDto  inventoryDto);

    InventoryDto getById(Integer id);

    List<InventoryDto> getAllInventoriesByPage(Pageable pageable);

    List<InventoryDto> getAllInventories();

    void delete(Integer id);
}
