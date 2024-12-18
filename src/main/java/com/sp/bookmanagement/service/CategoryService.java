package com.sp.bookmanagement.service;

import com.sp.bookmanagement.dto.CategoryDTO;

import java.util.List;

public interface CategoryService {
    public CategoryDTO createCategory(CategoryDTO categoryDTO) ;

    public List<CategoryDTO> getAllCategories() ;
}
