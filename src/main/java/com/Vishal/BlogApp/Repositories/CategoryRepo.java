package com.Vishal.BlogApp.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Vishal.BlogApp.Entities.Category;

public interface CategoryRepo extends JpaRepository<Category,Integer>{
 
}
