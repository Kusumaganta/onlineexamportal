package com.exam.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

import com.exam.dto.CategoryDTO;
import com.exam.dto.UserDTO;
import com.exam.entity.Category;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.service.CategoryService;

@RestController//for direct respone
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private Environment environment;
	@PostMapping("/")
	public ResponseEntity<String> addCategory(@RequestBody CategoryDTO category) throws CategoryAlreadyExistsException{
		Category categoryId = categoryService.addCategory(category);
// return new ResponseEntity<String>environment.getProperty("API.INSERT_SUCCESS") + categoryId ;
	return new ResponseEntity<String>("API.INSERT_CREATED", HttpStatus.CREATED);
//	CategoryDto category1=this.categoryService.addCategory(category);
//	return ResponseEntity.ok(category);
		
	}
	@GetMapping("/{cid}")
	public CategoryDTO getCategory(@PathVariable("cid")Long cid) throws CategoryNotFoundException {
		CategoryDTO category=categoryService.getCategory(cid);
		return category;
//		CategoryDto category=categoryService.getCategory(categoryId);
	//return new ResponseEntity<>(category, HttpStatus.OK);
		
	}
	@GetMapping("/")
	public ResponseEntity<?> getCategories()
	{
		return ResponseEntity.ok(this.categoryService.getCategories());
		
	}
	
	@PutMapping("/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable Long categoryId ,@RequestBody CategoryDTO category) throws CategoryNotFoundException{
		//Category category1=categoryService.updateCategory(category);
		categoryService.updateCategory(categoryId,category.getTitle());
		return new ResponseEntity<>("Records are updated",HttpStatus.OK);
		//return this.categoryService.updateCategory(category);
	}
	
	@DeleteMapping("/{categoryId}")
	
		public void deleteCategory(@PathVariable("categoryId") long categoryId) 
		{
			this.categoryService.deleteCategory(categoryId);
		}
	}

