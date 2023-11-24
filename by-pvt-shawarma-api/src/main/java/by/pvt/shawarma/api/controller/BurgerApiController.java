package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.BurgerDto;
import by.pvt.shawarma.api.dto.IngridientDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("burgers")
public interface BurgerApiController {
    @PostMapping("/searchForBurgerName")
    List<BurgerDto> getBurgersDtoByIngridient(@RequestBody IngridientDto ingridientDto);
}
