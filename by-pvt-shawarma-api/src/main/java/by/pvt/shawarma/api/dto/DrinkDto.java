package by.pvt.shawarma.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DrinkDto {
    private Long id;
    private String type;
    private Long code;
    private BigDecimal price;
}
