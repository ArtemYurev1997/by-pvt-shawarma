package by.pvt.shawarma.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BasketDrinkDto {
    private OrderRequest orderRequest;
    private DrinkDto drink;
    private Long count;
    private BigDecimal cost;
}
