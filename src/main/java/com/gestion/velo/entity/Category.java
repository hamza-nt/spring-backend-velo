package com.gestion.velo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "categories", schema = "production")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    int categoryId;

    @Column(name = "category_name", nullable = false)
    String categoryName;
}