package by.pvt.shawarma.api.dto;

import lombok.Data;

@Data
public class UserResponse {
    private Long id;
    private String name;
    private String surname;
    private String login;
    private String role;
}
