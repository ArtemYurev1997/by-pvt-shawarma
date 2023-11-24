package by.pvt.shawarma.core.service;

import by.pvt.shawarma.api.contract.BurgerApi;
import by.pvt.shawarma.api.dto.BurgerDto;
import by.pvt.shawarma.core.mapper.BurgerMappers;
import by.pvt.shawarma.core.repository.BurgerRepository;
import by.pvt.shawarma.core.repository.IngridientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BurgerServiceApi implements BurgerApi {
    private final BurgerRepository burgerRepository;
    private final BurgerMappers burgerMappers;
    private final IngridientRepository ingridientRepository;

    @Override
    public List<BurgerDto> getBurgersDtoByIngridient(String name) {
        return burgerRepository.getBurgersByIngridientName(name).stream().map(burgerMappers::toDto).collect(Collectors.toList());
    }
}
