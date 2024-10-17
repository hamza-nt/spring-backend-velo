package com.gestion.velo.dto;

import jakarta.validation.constraints.Min;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StockDTO {
    int storeId;
    int productId;
    @Min(message = "erreur nombre négative", value = 0)
    int quantity;
}
