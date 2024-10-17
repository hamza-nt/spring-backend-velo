package com.gestion.velo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stocks", schema = "production")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@IdClass(StockId.class)
public class Stock {

    @Id
    @Column(name = "store_id")
    int storeId;

    @Id
    @Column(name = "product_id")
    int productId;

    @Column(name = "quantity")
    int quantity;

}