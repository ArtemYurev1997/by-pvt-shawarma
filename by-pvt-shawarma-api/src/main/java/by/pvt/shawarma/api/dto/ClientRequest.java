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
public class ClientRequest extends UserRequest{
    @NotNull(message = "Поле должно содержать дату первого посещения")
    private LocalDate firstVisit;
    @NotNull(message = "Поле должно содержать дату последнего посещения")
    private LocalDate lastVisit;
    @NotBlank(message = "Поле должно содержать номер телефона")
    private String telephone;
    @NotNull(message = "Поле должно содержать потраченную сумму")
    @PositiveOrZero(message = "Поле должно содержать ноль или положительное значение суммы")
    private BigDecimal amountSpent;
}
