package com.Vishal.BlogApp.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Vishal.BlogApp.Payloads.CategoryDto;


public interface CategoryService {
     
	//create
	 CategoryDto createCategory(CategoryDto categoryDto);
	
	//update
	 CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
	 
	 //delete
	 void deleteCategory(Integer categoryId);
	 
	 //get
	 CategoryDto getCategory(Integer categoryId);
	 
	 //getAll
	 List<CategoryDto> getCategories();

	
}
