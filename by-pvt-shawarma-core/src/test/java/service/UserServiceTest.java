package service;

import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import by.pvt.shawarma.core.entity.User;
import by.pvt.shawarma.core.mapper.UserMappers;
import by.pvt.shawarma.core.repository.UserRepository;
import by.pvt.shawarma.core.service.UserServiceApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserMappers userMappers;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserServiceApi userServiceApi;

    @Test
    public void register_positiveTest() {
        User user = client();
        UserRequest userRequest = clientRequest();
        UserResponse userResponse = new UserResponse();
        when(userMappers.toEntity(userRequest)).thenReturn(client());
        when(userRepository.save(any())).thenReturn(user);
        when(userMappers.toResponse(any())).thenReturn(userResponse);
        UserResponse actualResult = userServiceApi.register(userRequest);
        assertEquals(userResponse, actualResult);
    }

    private User client() {
        User client = new User();
        client.setId(1L);
        client.setName("Валерий");
        client.setSurname("Валерьев");
        client.setLogin("Valery666");
        client.setPassword("6666");
        return client;
    }

    private UserRequest clientRequest() {
        UserRequest client = new UserRequest();
        client.setId(2L);
        client.setName("Валерий");
        client.setSurname("Валерьев");
        client.setLogin("Valery666");
        client.setPassword("8888");
        client.setRole("USER");
        return client;
    }
}
