package by.pvt.shawarma.core.controller;

import by.pvt.shawarma.api.contract.UserApi;
import by.pvt.shawarma.api.controller.UserApiController;
import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import jakarta.servlet.ServletException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApiController {
    private final UserApi userApi;

    @Override
    public List<UserResponse> findAll() {
        return userApi.getAllUsers();
    }

    @Override
    public UserResponse add(UserRequest userRequest) {
        return userApi.register(userRequest);
    }

    @Override
    public void delete(Long id) {
        userApi.delete(id);
    }

    @Override
    public List<UserResponse> update(UserRequest userRequest) {
        return userApi.update(userRequest);
    }

    @Override
    public UserResponse findById(Long id) {
        return userApi.findClientById(id);
    }

    @Override
    public UserResponse authorise(UserRequest userRequest) throws ServletException {
        return userApi.authorise(userRequest);
    }
}
