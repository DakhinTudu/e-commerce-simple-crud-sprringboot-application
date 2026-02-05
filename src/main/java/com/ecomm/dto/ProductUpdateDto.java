package com.ecomm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class ProductUpdateDto {
    private String productName;
    private String description;
    @Positive(message = "Product price must be greater than 0")
    private Double productPrice;
    @PositiveOrZero(message = "Quantity cannot be negative")
    private Integer quantity;
}
