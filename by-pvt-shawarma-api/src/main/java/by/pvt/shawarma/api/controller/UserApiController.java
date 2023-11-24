package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import jakarta.servlet.ServletException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("users")
public interface UserApiController {
    @GetMapping("/getAll")
    List<UserResponse> findAll();

    @PostMapping("/add")
    UserResponse add(@RequestBody @Validated UserRequest userRequest);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PostMapping("/update")
    List<UserResponse> update(@RequestBody UserRequest userRequest);

    @GetMapping("/{id}")
    UserResponse findById(@PathVariable("id") Long id);

    @PostMapping("/authorise")
    UserResponse authorise(@RequestBody UserRequest userRequest) throws ServletException;
}
