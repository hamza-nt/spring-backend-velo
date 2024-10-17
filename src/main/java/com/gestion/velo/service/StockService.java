package com.gestion.velo.service;

import com.gestion.velo.dto.StockDTO;
import com.gestion.velo.entity.Stock;
import com.gestion.velo.mapper.StockMapper;
import com.gestion.velo.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class StockService {

    private final StockRepository stocksRepo;
    private final StockMapper stockMapper = StockMapper.INSTANCE;

    public StockDTO addOrUpdateStock(StockDTO stockDTO) {
        Stock stock = stockMapper.stockDTOToStock(stockDTO);
        return stockMapper.stockToStockDTO(stocksRepo.save(stock));
    }

    public StockDTO findStocksByProductIdAndStoreId(int productId, int storeId) {
        return stockMapper.stockToStockDTO(stocksRepo.findByProductIdAndStoreId(productId, storeId));
    }

    public List<StockDTO> findStocksByProductId(int productId) {
        List<Stock> stocks = stocksRepo.findByProductId(productId);
        return stockMapper.stocksToStockDTOs(stocks);
    }

    public List<StockDTO> findAllStocks() {
        List<Stock> stocks = stocksRepo.findAll();
        return stockMapper.stocksToStockDTOs(stocks);
    }
}