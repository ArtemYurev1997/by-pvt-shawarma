package by.pvt.shawarma.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AdminResponse extends UserResponse{
    private LocalDate dateEnter;
    private LocalDate dateExit;
    private String post;
    private BigDecimal salary;
}
