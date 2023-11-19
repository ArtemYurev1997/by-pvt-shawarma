package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.ClientRequest;
import by.pvt.shawarma.api.dto.ClientResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("clients")
public interface ClientApiController {

    @GetMapping("/getAll")
    List<ClientResponse> findAll();

    @PostMapping("/add")
    ClientResponse add(@RequestBody ClientRequest clientRequest);

    @PostMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PostMapping("/update")
    List<ClientResponse> update( @RequestBody ClientRequest clientRequest);

    @GetMapping("/{id}")
    ClientResponse findById(@PathVariable("id") Long id);

    @PostMapping("/authorise")
    ClientResponse authorise( @RequestBody ClientRequest clientRequest);
}
