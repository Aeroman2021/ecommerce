package com.project.ecommerce.model.service.impl;

import com.project.ecommerce.model.entity.Card;
import com.project.ecommerce.model.service.contract.CardService;
import com.project.ecommerce.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements CardService{

    private CardRepository cardRepository;


    @Autowired
    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card create(Card entity) {
        return null;
    }

    @Override
    public Card update(Integer integer, Card card) {
        return null;
    }

    @Override
    public Optional<Card> getById(Integer id) {
        return cardRepository.findById(id);
    }

    @Override
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public void delete(Integer integer) {

    }
}
