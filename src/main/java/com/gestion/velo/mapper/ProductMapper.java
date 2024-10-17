package com.gestion.velo.mapper;

import com.gestion.velo.dto.ProductDTO;
import com.gestion.velo.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "brand.brandId", target = "brandId")
    @Mapping(source = "category.categoryId", target = "categoryId")
    ProductDTO productToProductDTO(Product product);

    @Mapping(source = "brandId", target = "brand.brandId")
    @Mapping(source = "categoryId", target = "category.categoryId")
    Product productDTOToProduct(ProductDTO productDTO);

    List<ProductDTO> productsToProductDTOs(List<Product> products);
}
