package by.pvt.shawarma.api.contract;

import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import jakarta.servlet.ServletException;

import java.util.List;

public interface UserApi {
    UserResponse register(UserRequest userRequest);

    UserResponse authorise(UserRequest userRequest) throws ServletException;

    void delete(Long id);

    List<UserResponse> getAllUsers();

    UserResponse findClientById(Long id);

    List<UserResponse> update(UserRequest userRequest);
}
