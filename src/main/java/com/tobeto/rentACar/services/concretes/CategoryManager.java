package com.tobeto.rentACar.services.concretes;

import com.tobeto.rentACar.dataAccess.concretes.CategoryRepository;
import com.tobeto.rentACar.entities.concretes.Category;
import com.tobeto.rentACar.services.abstracts.CategoryService;
import com.tobeto.rentACar.services.dtos.categories.request.AddCategoryRequest;
import com.tobeto.rentACar.services.dtos.categories.request.UpdateCategoryRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryManager implements CategoryService {
    private final CategoryRepository categoryRepository;
    @Override
    public void addCategory(AddCategoryRequest request) {
        //Mapping:
        Category category = new Category();
        category.setCategoryName(request.getCategoryName());
        categoryRepository.save(category);
    }

    @Override
    public void updateCategory(UpdateCategoryRequest request) {
        List<Category> categories = categoryRepository.findAll();
        for (Category category:categories) {
            if (category.getCategoryName().equals(request.getCategoryName())){
                category.setCategoryName(request.getCategoryName());
                categoryRepository.save(category);
            }
        }

    }
}
