package com.gestion.velo.repository;

import com.gestion.velo.entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface StockRepository extends JpaRepository<Stock, Integer> {
    Stock findByProductIdAndStoreId(int productId, int storeId);
    List<Stock> findByProductId(int productId);
}