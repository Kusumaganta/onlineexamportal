package com.exam.service;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.dto.CategoryDTO;
import com.exam.entity.Category;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.repository.CategoryRepository;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Category addCategory(CategoryDTO category)throws CategoryAlreadyExistsException{
		Category local=this.categoryRepository.findByTitle(category.getTitle());
		if(local!=null) {
			throw new CategoryAlreadyExistsException();
		}else {
//		CategoryDto categoryEntity = new CategoryDto();
	Category categoryEntity = new Category();
	categoryEntity.setDescription(category.getDescription());
	categoryEntity.setTitle(category.getTitle());
	categoryEntity.setCid(category.getCid());
	Category category2=categoryRepository.save(categoryEntity);
	

		
		
	return categoryEntity ;
		}			
	}

	private Exception CategoryAlreadyExistsException() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateCategory(Long categoryId,String title) throws CategoryNotFoundException{
		if(categoryRepository.existsById(categoryId)) {
			Category category1= categoryRepository.findById(categoryId).get();
			category1.setTitle(title);
			categoryRepository.save(category1);
		}else {
		throw new CategoryNotFoundException();
		}
		
	}

	@Override
	public Set<Category> getCategories() {
		return  new LinkedHashSet<>(this.categoryRepository.findAll());
	}

 @Override
	public CategoryDTO getCategory(Long cid) throws CategoryNotFoundException{
		java.util.Optional<Category> optional= categoryRepository.findById(cid);
		Category category =  optional.orElseThrow(()-> new CategoryNotFoundException()) ;
////				.orElseThrow(() -> new InfyBankException("Service.CUSTOMER_NOT_FOUND"));
		CategoryDTO category2 = new CategoryDTO();
		category2.setCid(category.getCid());
		category2.setTitle(category.getTitle());
		category2.setDescription(category.getDescription());
//		
		return category2;
	}

	@Override
	public void deleteCategory(long categoryId) {
		Category category = new Category();
		category.setCid(categoryId);
		this.categoryRepository.delete(category);
		
	}




}
