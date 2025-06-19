package com.project.ecommerce.service.impl;

import com.project.ecommerce.model.entity.CardType;
import com.project.ecommerce.repository.CardTypeRepository;
import com.project.ecommerce.service.contract.CardTypeService;
import org.springframework.stereotype.Service;

@Service
public class CardTypeServiceImpl implements CardTypeService {

    private CardTypeRepository cardTypeRepository;

    public CardTypeServiceImpl(CardTypeRepository cardTypeRepository) {
        this.cardTypeRepository = cardTypeRepository;
    }

    @Override
    public CardType getById(int id) {
        return cardTypeRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Card Type not found"));
    }
}
