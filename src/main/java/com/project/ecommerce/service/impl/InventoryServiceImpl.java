package com.project.ecommerce.service.impl;

import com.project.ecommerce.model.Dto.InventoryDto;
import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.Inventory;
import com.project.ecommerce.model.entity.enums.InventoryStatus;
import com.project.ecommerce.model.mapper.InventoryMapper;
import com.project.ecommerce.repository.CardRepository;
import com.project.ecommerce.repository.InventoryRepository;
import com.project.ecommerce.service.contract.InventoryService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {
    private InventoryRepository inventoryRepository;
    private CardRepository cardRepository;
    private InventoryMapper inventoryMapper;

    public InventoryServiceImpl(InventoryRepository inventoryRepository, CardRepository cardRepository,
                                InventoryMapper inventoryMapper) {
        this.inventoryRepository = inventoryRepository;
        this.cardRepository = cardRepository;
        this.inventoryMapper = inventoryMapper;
    }

    @Override
    public InventoryDto createOrUpdate(InventoryDto inventoryDto) {
        Card card = cardRepository.findById(inventoryDto.getCardId())
                .orElseThrow(() -> new RuntimeException("Card not found"));

        Inventory inventory;
        if(inventoryDto.getId() == null){
            inventory = Inventory.builder()
                    .code(inventoryDto.getCode())
                    .card(card)
                    .status(InventoryStatus.AVAILABLE)
                    .build();
        }else {
            inventory = inventoryRepository.findById(inventoryDto.getId())
                    .orElseThrow(() -> new RuntimeException(""));
            inventory.setCode(inventoryDto.getCode());
            inventory.setCard(card);
            inventory.setStatus(InventoryStatus.SOLD);
        }

        Inventory result = inventoryRepository.save(inventory);
        return inventoryMapper.toDto(result);
    }

    @Override
    public InventoryDto getById(Integer id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        return inventoryMapper.toDto(inventory);
    }

    @Override
    public List<InventoryDto> getAllInventoriesByPage(Pageable pageable) {
        return inventoryRepository.findAll(pageable)
                .stream()
                .map(inventoryMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<InventoryDto> getAllInventories() {
         return inventoryRepository.findAll()
                 .stream()
                 .map(inventoryMapper::toDto)
                 .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        Inventory inventory = inventoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inventory not found"));
        inventory.softDelete();
        inventoryRepository.save(inventory);
    }

    @Override
    public Long countInventoriesByCardIdAndStatus(int CardId, InventoryStatus status) {
        return inventoryRepository.countInventoriesByCardIdAndStatus(CardId,status);
    }
}
