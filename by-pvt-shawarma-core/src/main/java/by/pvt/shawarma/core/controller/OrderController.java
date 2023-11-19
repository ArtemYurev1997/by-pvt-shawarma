package by.pvt.shawarma.core.controller;

import by.pvt.shawarma.api.contract.BasketApi;
import by.pvt.shawarma.api.contract.OrderApi;
import by.pvt.shawarma.api.controller.OrderApiController;
import by.pvt.shawarma.api.dto.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class OrderController implements OrderApiController {
    private final OrderApi orderApi;
    private final BasketApi basketApi;

    public OrderController(@Qualifier("orderServiceApi") OrderApi orderApi, @Qualifier("basketServiceApi") BasketApi basketApi) {
        this.orderApi = orderApi;
        this.basketApi = basketApi;
    }

    @GetMapping("/getAll")
    public List<OrderResponse> getAll() {
        return orderApi.getAll();
    }

    @PostMapping("/add")
    public OrderResponse add(@RequestBody OrderRequest orderRequest) {
        return orderApi.save(orderRequest);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) {
        orderApi.delete(id);
    }

    @PostMapping("/create/newOrder")
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
        return orderApi.createOrder(orderRequest);
    }

    @GetMapping("/{id}")
    public OrderResponse findById(@PathVariable("id") Long id) {
        return orderApi.findById(id);
    }

    @PostMapping("/addClientToOrder")
    public OrderResponse updateOrderToClient(@RequestBody OrderRequest orderRequest) {
        return orderApi.updateOrderToClient(orderRequest);
    }

    @PostMapping("/addCostAndCount")
    public OrderResponse addCostAndCountToOrder(@RequestBody OrderRequest orderRequest) {
        return orderApi.addCostAndCountToOrder(orderRequest);
    }

    @PostMapping("/checkout")
    public OrderResponse checkout(@RequestBody OrderRequest orderRequest) {
        return orderApi.checkOut(orderRequest);
    }

    @PostMapping("/payment")
    public OrderResponse payment(@RequestBody OrderRequest orderRequest) {
        return orderApi.payment(orderRequest);
    }

    @GetMapping("/getOrdersByUserId/{id}")
    public List<OrderResponse> getOrdersByUserId(@PathVariable("id") Long userId) {
        return orderApi.getOrdersByUserId(userId);
    }

    @PostMapping("/changeStatus")
    public OrderResponse changeStatus(@RequestBody OrderRequest orderRequest) {
        return orderApi.changeStatus(orderRequest);
    }

    @PostMapping("/createComment")
    public CommentResponse createCommentByClient(@RequestBody CommentRequest commentRequest) {
        return orderApi.createCommentByClient(commentRequest);
    }

    @GetMapping("/page")
    public Page<OrderResponse> getOrderResponses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size) {
        return orderApi.getOrdersPages(page, size);
    }

    @PostMapping("/addShawarmaToBasket")
    public OrderResponse addShawarmaToBasket(@RequestBody BasketShawarmaDto basketShawarmaDto) {
        Long shawarmaId = basketShawarmaDto.getShawarma().getId();
        Long orderId = basketShawarmaDto.getOrderRequest().getId();
        basketApi.createBasketWithShawarma(orderId, shawarmaId, basketShawarmaDto.getCount());
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/addBurgerToBasket")
    public OrderResponse addBurgerToBasket(@RequestBody BasketBurgerDto basketBurgerDto) {
        Long burgerId = basketBurgerDto.getBurger().getId();
        Long orderId = basketBurgerDto.getOrderRequest().getId();
        basketApi.createBasketWithBurger(orderId, burgerId, basketBurgerDto.getCount());
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/addDrinkToBasket")
    public OrderResponse addDrinkToBasket(@RequestBody BasketDrinkDto basketDrinkDto) {
        Long drinkId = basketDrinkDto.getDrink().getId();
        Long orderId = basketDrinkDto.getOrderRequest().getId();
        basketApi.createBasketWithDrink(orderId, drinkId, basketDrinkDto.getCount());
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/deleteShawarmaToBasket")
    public OrderResponse deleteShawarmaToBasket(@RequestBody BasketShawarmaDto basketShawarmaDto) {
        Long shawarmaId = basketShawarmaDto.getShawarma().getId();
        Long orderId = basketShawarmaDto.getOrderRequest().getId();
        basketApi.deleteBasketWithShawarma(orderId, shawarmaId);
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/deleteBurgerToBasket")
    public OrderResponse deleteBurgerToBasket(@RequestBody BasketBurgerDto basketBurgerDto) {
        Long shawarmaId = basketBurgerDto.getBurger().getId();
        Long orderId = basketBurgerDto.getOrderRequest().getId();
        basketApi.deleteBasketWithBurger(orderId, shawarmaId);
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/deleteDrinkToBasket")
    public OrderResponse deleteDrinkToBasket(@RequestBody BasketDrinkDto basketDrinkDto) {
        Long drinkId = basketDrinkDto.getDrink().getId();
        Long orderId = basketDrinkDto.getOrderRequest().getId();
        basketApi.deleteBasketWithDrink(orderId, drinkId);
        return orderApi.getOrderById(orderId);
    }

    @PostMapping("/totalPrice")
    public BigDecimal totalPriceOfOrder(@RequestBody OrderRequest orderRequest) {
        return basketApi.totalPriceAllBasketsForOrder(orderRequest.getId());
    }

    @PostMapping("/totalCount")
    public Long totalCountOfOrder(@RequestBody OrderRequest orderRequest) {
        return basketApi.totalCountAllBasketsForOrder(orderRequest.getId());
    }
}
