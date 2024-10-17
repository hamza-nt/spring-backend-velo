package com.gestion.velo.service;

import com.gestion.velo.dto.ProductDTO;
import com.gestion.velo.entity.Brand;
import com.gestion.velo.entity.Category;
import com.gestion.velo.entity.Product;
import com.gestion.velo.mapper.ProductMapper;
import com.gestion.velo.repository.BrandRepository;
import com.gestion.velo.repository.CategoryRepository;
import com.gestion.velo.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository productsRepo;
    private final BrandRepository brandRepo;
    private final CategoryRepository categoriesRepo;
    private final ProductMapper productMapper = ProductMapper.INSTANCE;

    public ProductDTO addProduct(ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        Brand brand = brandRepo.findById(productDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        product.setBrand(brand);
        Category category = categoriesRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productMapper.productToProductDTO(productsRepo.save(product));
    }

    public ProductDTO updateProduct(int id, ProductDTO productDTO) {
        if (!productsRepo.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        Product product = productMapper.productDTOToProduct(productDTO);
        product.setProductId(id);
        Brand brand = brandRepo.findById(productDTO.getBrandId())
                .orElseThrow(() -> new RuntimeException("Brand not found"));
        product.setBrand(brand);
        Category category = categoriesRepo.findById(productDTO.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        product.setCategory(category);
        return productMapper.productToProductDTO(productsRepo.save(product));
    }

    public void deleteProductById(int id) {
        if (!productsRepo.existsById(id)) {
            throw new RuntimeException("Product not found");
        }
        productsRepo.deleteById(id);
    }

    public ProductDTO findProductById(int id) {
        Optional<Product> productOptional = productsRepo.findById(id);
        return productOptional.map(productMapper::productToProductDTO)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public List<ProductDTO> findAllProducts() {
        return productMapper.productsToProductDTOs(productsRepo.findAll());
    }
}
