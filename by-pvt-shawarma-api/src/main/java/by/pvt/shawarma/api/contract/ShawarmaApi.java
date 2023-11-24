package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.ShawarmaDto;

import java.util.List;

public interface ShawarmaApi {
    List<ShawarmaDto> getShawarmaDtoByIngridient(String name);

    ShawarmaDto createShawarma( Long start, Long end, String type, Long code);
}
