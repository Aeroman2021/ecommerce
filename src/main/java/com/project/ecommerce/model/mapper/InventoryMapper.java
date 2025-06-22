package com.project.ecommerce.model.mapper;

import com.project.ecommerce.model.Dto.InventoryDto;
import com.project.ecommerce.model.entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel ="spring")
public interface InventoryMapper {

    @Mapping(source = "card.id",target = "cardId")
    InventoryDto toDto(Inventory inventory);

    @Mapping(source = "cardId",target = "card.id")
    Inventory toEntity(InventoryDto inventoryDto);
}
