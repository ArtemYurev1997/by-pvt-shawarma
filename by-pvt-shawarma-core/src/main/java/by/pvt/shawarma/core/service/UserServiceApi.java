package by.pvt.shawarma.core.service;

import by.pvt.shawarma.api.contract.UserApi;
import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import by.pvt.shawarma.core.entity.User;
import by.pvt.shawarma.core.exception.AccountException;
import by.pvt.shawarma.core.mapper.UserMappers;
import by.pvt.shawarma.core.repository.UserRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Primary
public class UserServiceApi implements UserApi, UserDetailsService {
    private final UserRepository userRepository;
    private final UserMappers userMappers;
    private final PasswordEncoder passwordEncoder;
    private final HttpServletRequest httpServletRequest;

    @Override
    public UserResponse register(UserRequest userRequest) {
        if(userRequest.getLogin() != null) {
            throw new AccountException("Логин занят!");
        }
        User user = userMappers.toEntity(userRequest);
        String password = passwordEncoder.encode(userRequest.getPassword());
        user.setPassword(password);
        userRepository.save(user);
        return userMappers.toResponse(user);
    }

    @Override
    public UserResponse authorise(UserRequest userRequest) throws ServletException {
        httpServletRequest.login(userRequest.getLogin(), userRequest.getPassword());
        HttpSession httpSession = httpServletRequest.getSession();
        httpSession.setMaxInactiveInterval(30);
        User user = userRepository.authorise(userRequest.getLogin(), userRequest.getPassword());
        if(user != null){
            return userMappers.toResponse(user);
        } else {
            throw new AccountException("Пользователь не найден!");
        }
    }


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        User user = userRepository.loadUserByUserName(login);
        return org.springframework.security.core.userdetails.User.builder()
                .username(user.getLogin())
                .password(user.getPassword())
                .roles(user.getRole())
                .build();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream().map(userMappers::toResponse).collect(Collectors.toList());
    }

    @Override
    public UserResponse findClientById(Long id) {
        Optional<UserResponse> admin = Optional.of(userMappers.toResponse(userRepository.findById(id).orElseThrow(() -> new AccountException("404!"))));
        return admin.get();
    }

    @Override
    public List<UserResponse> update(UserRequest userRequest) {
        Optional<User> user = userRepository.findById(userRequest.getId());
        if (user.isPresent()) {
            userRepository.save(userMappers.toEntity(userRequest));
        }
        return getAllUsers();
    }
}
