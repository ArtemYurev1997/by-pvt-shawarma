package by.pvt.shawarma.api.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CommentResponse {
    private Long id;
    private String comment;
    private LocalDate date;
}
