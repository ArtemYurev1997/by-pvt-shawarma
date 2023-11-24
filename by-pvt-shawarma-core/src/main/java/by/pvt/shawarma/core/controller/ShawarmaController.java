package by.pvt.shawarma.core.controller;

import by.pvt.shawarma.api.contract.ShawarmaApi;
import by.pvt.shawarma.api.controller.ShawarmaApiController;
import by.pvt.shawarma.api.dto.IngridientDto;
import by.pvt.shawarma.api.dto.ShawarmaCreateRequest;
import by.pvt.shawarma.api.dto.ShawarmaDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShawarmaController implements ShawarmaApiController {
    private final ShawarmaApi shawarmaApi;

    public ShawarmaController(@Qualifier("shawarmaServiceApi") ShawarmaApi shawarmaApi) {
        this.shawarmaApi = shawarmaApi;
    }

    @PostMapping("/searchForShawarmaName")
    public List<ShawarmaDto> getShawarmaDtoByIngridient(@RequestBody IngridientDto ingridientDto) {
        String name = ingridientDto.getName();
        return shawarmaApi.getShawarmaDtoByIngridient(name);
    }

    @PostMapping("/createShawarma")
    public ShawarmaDto createShawarma(@RequestBody ShawarmaCreateRequest shawarmaCreateRequest) {
        String type = shawarmaCreateRequest.getShawarmaRequest().getType();
        Long code = shawarmaCreateRequest.getShawarmaRequest().getCode();
        Long start = shawarmaCreateRequest.getIngridientDto1().getId();
        Long end = shawarmaCreateRequest.getIngridientDto2().getId();
        return shawarmaApi.createShawarma(start, end, type, code);
    }
}
