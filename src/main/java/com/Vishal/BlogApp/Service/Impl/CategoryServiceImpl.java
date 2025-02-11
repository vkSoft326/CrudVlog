package com.Vishal.BlogApp.Service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Vishal.BlogApp.Entities.Category;
import com.Vishal.BlogApp.Payloads.CategoryDto;
import com.Vishal.BlogApp.Repositories.CategoryRepo;
import com.Vishal.BlogApp.Service.CategoryService;
import com.Vishal.BlogApp.exceptions.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
	
		Category cat=this.modelMapper.map(categoryDto, Category.class);
		
		Category addedCat=this.categoryRepo.save(cat);
		
		return this.modelMapper.map(addedCat,CategoryDto.class);
		
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat=this.categoryRepo.findById(categoryId)
				.orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		
		cat.setCategoryTitle(categoryDto.getCategoryTitle());
		cat.setCategoryDescription(categoryDto.getCategoryDescription());
		 Category updatedCategory=this.categoryRepo.save(cat);
		 return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		this.categoryRepo.delete(cat);

	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		// TODO Auto-generated method stub
		Category cat=this.categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","Category Id",categoryId));
		return this.modelMapper.map(cat,  CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getCategories() {
		// TODO Auto-generated method stub
		
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> catDtos=categories.stream().map((cat)->this.modelMapper
				.map(cat, CategoryDto.class)).collect(Collectors.toList());
		
		return catDtos;
	}

}
