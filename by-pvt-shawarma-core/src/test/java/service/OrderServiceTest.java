package service;

import by.pvt.shawarma.api.dto.ClientRequest;
import by.pvt.shawarma.api.dto.OrderRequest;
import by.pvt.shawarma.api.dto.OrderResponse;
import by.pvt.shawarma.api.enums.Status;
import by.pvt.shawarma.core.entity.Client;
import by.pvt.shawarma.core.entity.Order;
import by.pvt.shawarma.core.exception.AccountException;
import by.pvt.shawarma.core.mapper.OrderMappers;
import by.pvt.shawarma.core.repository.ClientRepository;
import by.pvt.shawarma.core.repository.OrderRepository;
import by.pvt.shawarma.core.service.OrderServiceApi;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class OrderServiceTest {
    @Mock
    private OrderRepository orderRepository;

    @Mock
    private ClientRepository clientRepository;

    @Mock
    private OrderMappers orderMappers;

    @InjectMocks
    private OrderServiceApi orderServiceApi;

    @Test
    public void positiveTest() {
        Order order = new Order();
        OrderResponse orderResponse = new OrderResponse();
        when(clientRepository.findById(1L)).thenReturn(Optional.of(client()));
        when(orderRepository.getOrdersByUserId(1L)).thenReturn(new ArrayList<>());
        when(orderRepository.save(any())).thenReturn(order);
        when(orderMappers.toResponse(any())).thenReturn(orderResponse);
        OrderResponse actualResult = orderServiceApi.createOrder(orderRequest());
        assertEquals(actualResult, orderResponse);
    }

    @Test
    public void negativeTest() {
        lenient().when(clientRepository.findById(2L)).thenReturn(Optional.of(client()));
        Exception exception = assertThrows(AccountException.class, () -> orderServiceApi.createOrder(orderRequest()));
        assertEquals(exception.getMessage(), "Заказа с пользователем не существует");
    }

    private Client client() {
        Client client = new Client();
        client.setId(1L);
        client.setName("Валерий");
        client.setSurname("Валерьев");
        client.setLogin("Valery666");
        client.setPassword("6666");
        client.setRole("USER");
        client.setAddress("Ленина 67-44");
        client.setFirstVisit(LocalDate.of(2023, 4, 21));
        client.setLastVisit(LocalDate.of(2023, 6, 27));
        client.setAmountSpent(new BigDecimal(10));
        return client;
    }

    private OrderRequest orderRequest() {
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setId(1L);
        orderRequest.setUserId(clientRequest());
        orderRequest.setCost(new BigDecimal(5));
        orderRequest.setCount(3L);
        orderRequest.setDate(LocalDate.now());
        orderRequest.setAddress("Ленина 12");
        orderRequest.setTelephone("+375294762342");
        orderRequest.setStatus(Status.UNFORMED.getName());
        orderRequest.setPayment(Status.NO_PAY.toString());
        orderRequest.setComment("Жду заказ!");
        return orderRequest;
    }

    private ClientRequest clientRequest() {
        ClientRequest client = new ClientRequest();
        client.setId(1L);
        client.setName("Валерий");
        client.setSurname("Валерьев");
        client.setLogin("Valery666");
        client.setPassword("6666");
        client.setRole("USER");
        client.setFirstVisit(LocalDate.of(2023, 4, 21));
        client.setLastVisit(LocalDate.of(2023, 6, 27));
        client.setAmountSpent(new BigDecimal(10));
        return client;
    }
}
