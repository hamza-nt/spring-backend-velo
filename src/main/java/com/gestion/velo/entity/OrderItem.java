package com.gestion.velo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Entity
@Table(name = "order_Items",schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {
    @Id
    @Column(name = "item_id")
    int itemId;

    @OneToOne
    @JoinColumn(name = "order_id")
    Order order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    Product product;

    @Column(name = "quantity", nullable = false)
    int quantity;

    @Column(name = "list_price", nullable = false)
    BigDecimal listPrice;

    @Column(name = "discount", nullable = false)
    BigDecimal discount;

}
