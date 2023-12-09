package com.tobeto.rentACar.services.abstracts;

import com.tobeto.rentACar.services.dtos.categories.request.AddCategoryRequest;
import com.tobeto.rentACar.services.dtos.categories.request.UpdateCategoryRequest;

public interface CategoryService {
    public void addCategory(AddCategoryRequest request);
    public void updateCategory(UpdateCategoryRequest request);
}
