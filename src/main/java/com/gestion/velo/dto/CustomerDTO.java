package com.gestion.velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomerDTO {
    int customerId;
    @NotBlank(message = "Le prénom ne peut pas être vide")
    String firstName;
    @NotBlank(message = "Le nom ne peut pas être vide")
    String lastName;
    String phoneNumber;
    String email;
    String street;
    String city;
    String state;
    String zipCode;
}
