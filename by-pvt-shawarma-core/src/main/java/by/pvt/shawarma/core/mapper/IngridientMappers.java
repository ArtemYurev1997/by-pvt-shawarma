package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.IngridientDto;
import by.pvt.shawarma.core.entity.Ingridient;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IngridientMappers {
    IngridientDto toDto(Ingridient ingridient);
}
