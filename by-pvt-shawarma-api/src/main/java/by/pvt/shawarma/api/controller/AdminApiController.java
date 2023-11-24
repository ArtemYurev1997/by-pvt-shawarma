package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.AdminRequest;
import by.pvt.shawarma.api.dto.AdminResponse;
import jakarta.servlet.ServletException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("admins")
public interface AdminApiController {

    @GetMapping("/getAll")
    List<AdminResponse> findAll();

    @PostMapping("/add")
    AdminResponse add(@RequestBody @Validated AdminRequest adminRequest);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PostMapping("/update")
    List<AdminResponse> update(@RequestBody AdminRequest adminRequest);

    @GetMapping("/{id}")
    AdminResponse findById(@PathVariable("id") Long id);

    @PostMapping("/authorise")
    AdminResponse authorise(@RequestBody AdminRequest adminRequest) throws ServletException;
}

