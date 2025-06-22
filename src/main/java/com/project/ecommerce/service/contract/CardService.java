package com.project.ecommerce.service.contract;

import com.project.ecommerce.model.Dto.CardDto;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface CardService  {

    CardDto createOrUpdate(CardDto cardDto);

    CardDto getById(Integer id);

    List<CardDto> getAllCardsByPage(Pageable pageable);

    List<CardDto> getAllCards();

    void delete(Integer id);

}
