package com.gestion.velo.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "orders",schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {
    @Id
    @Column(name = "order_id")
    int orderId;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    Customer customer;

    @Column(name="order_status", nullable = false)
    byte orderStatus;

    @Column(name="order_date", nullable = false)
    LocalDate orderDate;

    @Column(name="required_date", nullable = false)
    LocalDate requiredDate;

    @Column(name="shipped_date")
    LocalDate shippedDate;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    Store store;

    @ManyToOne
    @JoinColumn(name = "staff_id", nullable = false)
    Staff staff;

}
