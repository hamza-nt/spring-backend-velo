package com.gestion.velo.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryDTO {
    int categoryId;
    @NotBlank(message = "Le nom ne peut pas être vide")
    String categoryName;
}