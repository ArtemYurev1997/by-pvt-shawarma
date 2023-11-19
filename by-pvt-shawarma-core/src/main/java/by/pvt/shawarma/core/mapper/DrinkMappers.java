package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.DrinkDto;
import by.pvt.shawarma.core.entity.Drink;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DrinkMappers {
    DrinkDto toDto(Drink drink);
}
