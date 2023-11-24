package by.pvt.shawarma.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class ClientResponse extends UserResponse {
    private LocalDate firstVisit;
    private LocalDate lastVisit;
    private String telephone;
    private BigDecimal amountSpent;
}
