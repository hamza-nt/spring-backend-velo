package com.gestion.velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StoreDTO {
    int storeId;
    @NotBlank(message = "Le nom ne peut pas être vide")
    String storeName;
    String phone;
    String email;
    String street;
    String city;
    String state;
    String zipCode;
}
