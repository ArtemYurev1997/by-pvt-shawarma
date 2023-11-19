package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.BasketBurgerDto;
import by.pvt.shawarma.api.dto.BasketDrinkDto;
import by.pvt.shawarma.api.dto.BasketShawarmaDto;
import by.pvt.shawarma.core.entity.BasketBurger;
import by.pvt.shawarma.core.entity.BasketDrink;
import by.pvt.shawarma.core.entity.BasketShawarma;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BasketMappers {
    BasketShawarmaDto toBasketShawarmaDto(BasketShawarma basketShawarma);
    BasketBurgerDto toBasketBurgerDto(BasketBurger basketBurger);
    BasketDrinkDto toBasketDrinkDto(BasketDrink basketDrink);

    BasketShawarma toBasketShawarmaEntity(BasketShawarmaDto basketShawarmaDto);
    BasketBurger toBasketBurgerEntity(BasketBurgerDto basketBurgerDto);
    BasketDrink toBasketDrinkEntity(BasketDrinkDto basketDrinkDto);
}
