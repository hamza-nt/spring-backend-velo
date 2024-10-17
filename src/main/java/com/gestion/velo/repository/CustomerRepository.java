package com.gestion.velo.repository;

import com.gestion.velo.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    List<Customer> findByCity(String city);
    List<Customer> findByZipCode(String zipCode);
    List<Customer> findByCityAndZipCode(String city, String zipCode);

}