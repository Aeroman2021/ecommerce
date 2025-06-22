package com.project.ecommerce.model.mapper;

import com.project.ecommerce.model.Dto.CardDto;
import com.project.ecommerce.model.entity.Card;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CardMapper {

    @Mapping(source = "region.id",target = "regionId")
    @Mapping(source = "cardType.id",target = "cardTypeId")
    CardDto toDto(Card card);

    @Mapping(target = "region.id",source = "regionId")
    @Mapping(target = "cardType.id",source = "cardTypeId")
    Card toEntity(CardDto cardDto);
}
