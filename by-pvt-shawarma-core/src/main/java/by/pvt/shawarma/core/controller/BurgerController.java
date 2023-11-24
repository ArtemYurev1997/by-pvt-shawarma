package by.pvt.shawarma.core.controller;

import by.pvt.shawarma.api.contract.BurgerApi;
import by.pvt.shawarma.api.controller.BurgerApiController;
import by.pvt.shawarma.api.dto.BurgerDto;
import by.pvt.shawarma.api.dto.IngridientDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BurgerController implements BurgerApiController {
    private final BurgerApi burgerApi;

    public BurgerController(@Qualifier("burgerServiceApi") BurgerApi burgerApi) {
        this.burgerApi = burgerApi;
    }

    @PostMapping("/searchForBurgerName")
    public List<BurgerDto> getBurgersDtoByIngridient(@RequestBody IngridientDto ingridientDto) {
        String name = ingridientDto.getName();
        return burgerApi.getBurgersDtoByIngridient(name);
    }
}
