package by.pvt.shawarma.api.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class IngridientDto {
    private Long id;
    private String name;
    private BigDecimal price;
    private Long total;

    @Override
    public String toString() {
        return name;
    }
}
