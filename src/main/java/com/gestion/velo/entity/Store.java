package com.gestion.velo.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stores", schema = "sales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    int storeId;

    @Column(name = "store_name", nullable = false)
    String storeName;

    @Column(name = "phone")
    String phone;

    @Column(name = "email")
    String email;

    @Column(name = "street")
    String street;

    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Column(name = "zip_code")
    String zipCode;
}