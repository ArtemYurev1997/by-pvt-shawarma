package by.pvt.shawarma.api.controller;

import by.pvt.shawarma.api.dto.*;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("orders")
public interface OrderApiController {

    @GetMapping("/getAll")
    List<OrderResponse> getAll();

    @PostMapping("/add")
    OrderResponse add(@RequestBody OrderRequest orderRequest);

    @DeleteMapping("/delete/{id}")
    void delete(@PathVariable("id") Long id);

    @PostMapping("/create/newOrder")
    OrderResponse createOrder(@RequestBody OrderRequest orderRequest);

    @GetMapping("/{id}")
    OrderResponse findById(@PathVariable("id") Long id);

    @PostMapping("/addClientToOrder")
    OrderResponse updateOrderToClient(@RequestBody OrderRequest orderRequest);

    @PostMapping("/addCostAndCount")
    OrderResponse addCostAndCountToOrder(@RequestBody OrderRequest orderRequest);

    @PostMapping("/checkout")
    OrderResponse checkout(@RequestBody OrderRequest orderRequest);

    @PostMapping("/payment")
    OrderResponse payment(@RequestBody OrderRequest orderRequest);

    @GetMapping("/getOrdersByUserId/{id}")
    List<OrderResponse> getOrdersByUserId(@PathVariable("id") Long userId);

    @PostMapping("/changeStatus")
    OrderResponse changeStatus(@RequestBody OrderRequest orderRequest);

    @PostMapping("/createComment")
    CommentResponse createCommentByClient(@RequestBody CommentRequest commentRequest);

    @GetMapping("/page")
    Page<OrderResponse> getOrderResponses(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "2") int size);

    @PostMapping("/addShawarmaToBasket")
    OrderResponse addShawarmaToBasket(@RequestBody BasketShawarmaDto basketShawarmaDto);

    @PostMapping("/addBurgerToBasket")
    OrderResponse addBurgerToBasket(@RequestBody BasketBurgerDto basketBurgerDto);

    @PostMapping("/addDrinkToBasket")
    OrderResponse addDrinkToBasket(@RequestBody BasketDrinkDto basketDrinkDto);

    @PostMapping("/deleteShawarmaToBasket")
    OrderResponse deleteShawarmaToBasket(@RequestBody BasketShawarmaDto basketShawarmaDto);

    @PostMapping("/deleteBurgerToBasket")
    OrderResponse deleteBurgerToBasket(@RequestBody BasketBurgerDto basketBurgerDto);

    @PostMapping("/deleteDrinkToBasket")
    OrderResponse deleteDrinkToBasket(@RequestBody BasketDrinkDto basketDrinkDto);

    @PostMapping("/totalPrice")
    BigDecimal totalPriceOfOrder(@RequestBody OrderRequest orderRequest);

    @PostMapping("/totalCount")
    Long totalCountOfOrder(@RequestBody OrderRequest orderRequest);
}
