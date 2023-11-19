package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.BurgerDto;

import java.util.List;

public interface BurgerApi {
    List<BurgerDto> getBurgersDtoByIngridient(String name);
}
