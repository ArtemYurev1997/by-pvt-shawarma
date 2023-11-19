package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.AdminRequest;
import by.pvt.shawarma.api.dto.AdminResponse;
import by.pvt.shawarma.core.entity.Admin;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdminMappers {
    AdminResponse toResponse(Admin admin);
    Admin toEntity(AdminRequest adminRequest);
}
