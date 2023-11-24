package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.BurgerDto;
import by.pvt.shawarma.core.entity.Burger;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BurgerMappers {
    BurgerDto toDto(Burger burger);
}
