package com.gestion.velo.service;

import com.gestion.velo.dto.CategoryDTO;
import com.gestion.velo.entity.Category;
import com.gestion.velo.mapper.CategoryMapper;
import com.gestion.velo.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepo;
    private final CategoryMapper categoryMapper = CategoryMapper.INSTANCE;

    public CategoryDTO addCategory(CategoryDTO categoryDTO) {
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        return categoryMapper.categoryToCategoryDTO(categoryRepo.save(category));
    }

    public CategoryDTO updateCategory(int id, CategoryDTO categoryDTO) {
        if (!categoryRepo.existsById(id)) {
            return null;
        }
        Category category = categoryMapper.categoryDTOToCategory(categoryDTO);
        category.setCategoryId(id);
        return categoryMapper.categoryToCategoryDTO(categoryRepo.save(category));
    }

    public void deleteCategory(int categoryId) {
        categoryRepo.deleteById(categoryId);
    }

    public CategoryDTO getCategoryById(int categoryId) {
        Optional<Category> categoryOptional = categoryRepo.findById(categoryId);
        return categoryOptional.map(categoryMapper::categoryToCategoryDTO).orElse(null);
    }

    public List<CategoryDTO> getAllCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categoryMapper.categoriesToCategoryDTOs(categories);
    }
}
