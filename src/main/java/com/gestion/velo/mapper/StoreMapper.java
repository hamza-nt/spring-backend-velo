package com.gestion.velo.mapper;

import com.gestion.velo.dto.StoreDTO;
import com.gestion.velo.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface StoreMapper {
    StoreMapper INSTANCE = Mappers.getMapper(StoreMapper.class);

    StoreDTO storeToStoreDTO(Store store);
    Store storeDTOToStore(StoreDTO storeDTO);
    List<StoreDTO> storesToStoreDTOs(List<Store> stores);
}
