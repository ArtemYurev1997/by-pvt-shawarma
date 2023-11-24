package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.BasketBurgerDto;
import by.pvt.shawarma.api.dto.BasketDrinkDto;
import by.pvt.shawarma.api.dto.BasketShawarmaDto;

import java.math.BigDecimal;
import java.util.List;

public interface BasketApi {
    BasketShawarmaDto createBasketWithShawarma(Long orderId, Long shawarmaId, Long count);

    BasketBurgerDto createBasketWithBurger(Long orderId, Long burgerId, Long count);

    BasketDrinkDto createBasketWithDrink(Long orderId, Long drinkId, Long count);

    List<BasketShawarmaDto> deleteBasketWithShawarma(Long orderId, Long shawarmaId);

    List<BasketBurgerDto> deleteBasketWithBurger(Long orderId, Long burgerId);

    List<BasketDrinkDto> deleteBasketWithDrink(Long orderId, Long drinkId);

    BigDecimal totalPriceAllBasketsForOrder(Long orderId);

    Long totalCountAllBasketsForOrder(Long orderId);
}
