package com.gestion.velo.controller;

import com.gestion.velo.dto.StockDTO;
import com.gestion.velo.service.StockService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api/stocks")
@AllArgsConstructor
public class StockController {

    private final StockService stockService;

    @PostMapping
    public ResponseEntity<StockDTO> addStock(@Valid @RequestBody StockDTO stockDTO) {
        StockDTO createdStock = stockService.addOrUpdateStock(stockDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdStock);
    }

    @GetMapping("/{productId}/{storeId}")
    public ResponseEntity<StockDTO> getStocksByProductId(@PathVariable int productId, @PathVariable int storeId) {
        StockDTO stocks = stockService.findStocksByProductIdAndStoreId(productId, storeId);
        return ResponseEntity.status(HttpStatus.OK).body(stocks);
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<List<StockDTO>> getStocksByProductId(@PathVariable int productId) {
        List<StockDTO> stocks = stockService.findStocksByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body(stocks);
    }

    @GetMapping
    public ResponseEntity<List<StockDTO>> getAllStocks() {
        List<StockDTO> stocks = stockService.findAllStocks(); // Call the service method
        return ResponseEntity.status(HttpStatus.OK).body(stocks); // Return the list of stocks
    }
}