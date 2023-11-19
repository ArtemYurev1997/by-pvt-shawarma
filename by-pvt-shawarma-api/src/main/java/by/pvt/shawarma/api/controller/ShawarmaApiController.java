package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.IngridientDto;
import by.pvt.shawarma.api.dto.ShawarmaCreateRequest;
import by.pvt.shawarma.api.dto.ShawarmaDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("shawarmas")
public interface ShawarmaApiController {

    @PostMapping("/searchForShawarmaName")
    List<ShawarmaDto> getShawarmaDtoByIngridient(@RequestBody IngridientDto ingridientDto);

    @PostMapping("/createShawarma")
    ShawarmaDto createShawarma(@RequestBody ShawarmaCreateRequest shawarmaCreateRequest);
}
