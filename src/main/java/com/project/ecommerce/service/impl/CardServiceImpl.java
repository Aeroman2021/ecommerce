package com.project.ecommerce.service.impl;

import com.project.ecommerce.model.Dto.CardDto;
import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.entity.CardType;
import com.project.ecommerce.model.entity.Region;
import com.project.ecommerce.model.entity.embedables.AuditFields;
import com.project.ecommerce.model.entity.embedables.Description;
import com.project.ecommerce.model.mapper.CardMapper;
import com.project.ecommerce.repository.CardRepository;
import com.project.ecommerce.repository.CardTypeRepository;
import com.project.ecommerce.repository.InventoryRepository;
import com.project.ecommerce.repository.RegionRepository;
import com.project.ecommerce.service.contract.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final RegionRepository regionRepository;
    private final CardTypeRepository cardTypeRepository;
    private final InventoryRepository inventoryRepository;
    private final CardMapper cardMapper;

    @Autowired
    public CardServiceImpl(CardRepository cardRepository, RegionRepository regionRepository,
                           CardTypeRepository cardTypeRepository, InventoryRepository inventoryRepository,
                           CardMapper cardMapper) {
        this.cardRepository = cardRepository;
        this.regionRepository = regionRepository;
        this.cardTypeRepository = cardTypeRepository;
        this.inventoryRepository = inventoryRepository;
        this.cardMapper = cardMapper;
    }

    @Override
    public CardDto createOrUpdate(CardDto cardDto) {
        Region region = regionRepository.findById(cardDto.getRegionId())
                .orElseThrow(() -> new RuntimeException("Region Not Found"));

        CardType cardType = cardTypeRepository.findById(cardDto.getCardTypeId())
                .orElseThrow(() -> new RuntimeException("card type Not Found"));
        Card card;

        if (cardDto.getId() == null) {
            card = Card.builder()
                    .cardType(cardType)
                    .price(cardDto.getPrice())
                    .irPrice(cardDto.getIrPrice())
                    .description(new Description(cardDto.getDescriptionFa(), cardDto.getDescriptionEn()))
                    .region(region)
                    .build();
        }
        else {
            card = cardRepository.findById(cardDto.getId())
                    .orElseThrow(() -> new RuntimeException("card Not Found"));
            card.setCardType(cardType);
            card.setRegion(region);
            card.setPrice(cardDto.getPrice());
            card.setIrPrice(cardDto.getIrPrice());
            card.setDescription((new Description(cardDto.getDescriptionFa(),
                    cardDto.getDescriptionEn()))
            );
        }
         Card result = cardRepository.save(card);
         return cardMapper.toDto(result);
    }

    @Override
    public List<CardDto> getAllCardsByPage(Pageable pageable) {
        return cardRepository.findAll(pageable)
                .stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<CardDto> getAllCards() {
        return cardRepository.findAll()
                .stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto getById(Integer id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("card Not Found"));
        return cardMapper.toDto(card);
    }
    
    @Override
    public void delete(Integer id) {
        Card card = cardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("card  Not Found"));
        card.softDelete();
        cardRepository.save(card);
    }

}
