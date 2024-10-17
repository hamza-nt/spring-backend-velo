package com.gestion.velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StaffDTO {
    int staffId;
    @NotBlank(message = "Le prénom ne peut pas être vide")
    String firstName;
    @NotBlank(message = "Le nom ne peut pas être vide")
    String lastName;
    String email;
    String phone;
    byte active;
    Integer storeId;
    Integer managerId;
}