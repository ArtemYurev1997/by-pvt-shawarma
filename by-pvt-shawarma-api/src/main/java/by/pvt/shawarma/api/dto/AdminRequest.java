package by.pvt.shawarma.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AdminRequest extends UserRequest{
    @NotNull(message = "Поле должно содержать дату входа")
    private LocalDate dateEnter;
    private LocalDate dateExit;
    @NotBlank(message = "Поле должно содержать должность")
    private String post;
    @NotNull(message = "Поле должно содержать значение зарплаты")
    @PositiveOrZero(message = "Не отрицательное значение")
    private BigDecimal salary;
}
