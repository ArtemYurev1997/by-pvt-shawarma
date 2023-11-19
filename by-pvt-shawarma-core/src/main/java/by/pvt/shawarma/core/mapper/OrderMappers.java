package by.pvt.shawarma.core.mapper;

import by.pvt.shawarma.api.dto.OrderRequest;
import by.pvt.shawarma.api.dto.OrderResponse;
import by.pvt.shawarma.core.entity.Order;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = BasketMappers.class, injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface OrderMappers {
    OrderResponse toResponse(Order order);
    Order toEntity(OrderRequest orderRequest);
}
