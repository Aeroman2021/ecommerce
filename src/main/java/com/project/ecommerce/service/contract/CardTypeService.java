package com.project.ecommerce.service.contract;

import com.project.ecommerce.model.entity.CardType;
import org.springframework.stereotype.Service;

@Service
public interface CardTypeService {

    CardType getById(int id);
}
