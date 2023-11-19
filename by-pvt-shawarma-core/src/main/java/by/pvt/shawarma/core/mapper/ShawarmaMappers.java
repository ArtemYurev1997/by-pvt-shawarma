package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.ShawarmaDto;
import by.pvt.shawarma.core.entity.Shawarma;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ShawarmaMappers {
    ShawarmaDto toDto(Shawarma shawarma);
}
