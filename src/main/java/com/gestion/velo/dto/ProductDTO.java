package com.gestion.velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductDTO {
    int productId;
    @NotBlank(message = "Le nom ne peut pas être vide")
    String productName;
    int brandId;
    int categoryId;
    short modelYear;
    BigDecimal listPrice;
}