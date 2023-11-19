package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.UserRequest;
import by.pvt.shawarma.api.dto.UserResponse;
import by.pvt.shawarma.core.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMappers {
    User toEntity(UserRequest userRequest);
    UserResponse toResponse(User user);
}
