package com.gestion.velo.mapper;

import com.gestion.velo.dto.StockDTO;
import com.gestion.velo.entity.Stock;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface StockMapper {
    StockMapper INSTANCE = Mappers.getMapper(StockMapper.class);

    StockDTO stockToStockDTO(Stock stock);
    Stock stockDTOToStock(StockDTO stockDTO);
    List<StockDTO> stocksToStockDTOs(List<Stock> stocks);
}