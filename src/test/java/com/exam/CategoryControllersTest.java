package com.exam;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.exam.controller.CategoryController;
import com.exam.dto.CategoryDTO;
import com.exam.entity.Category;
import com.exam.exception.CategoryAlreadyExistsException;
import com.exam.exception.CategoryNotFoundException;
import com.exam.service.CategoryService;
@RunWith(MockitoJUnitRunner.class)
public class CategoryControllersTest {
	@InjectMocks
	private CategoryController categoryController;
	@Mock
    private CategoryService categoryService;
	private CategoryDTO categoryDTO;
	@Before
	public void setup() {
 categoryDTO = new CategoryDTO();
 categoryDTO.setCid(1L);
 categoryDTO.setTitle("Title1");
 categoryDTO.setDescription("Description1");
}
	@Test
 public void testAddCategory() throws CategoryAlreadyExistsException {
 when(categoryService.addCategory(categoryDTO)).thenReturn(new Category());
 ResponseEntity<String> response = categoryController.addCategory(categoryDTO);
 assertEquals(HttpStatus.CREATED, response.getStatusCode());
 assertEquals("API.INSERT_CREATED", response.getBody());
}
	@Test
 public void testGetCategory() throws CategoryNotFoundException {
 when(categoryService.getCategory(1L)).thenReturn(categoryDTO);
 CategoryDTO result = categoryController.getCategory(1L);
 assertEquals(categoryDTO, result);
}
@Test
 public void testUpdateCategory() throws CategoryNotFoundException {
 ResponseEntity<String> response = categoryController.updateCategory(1L, categoryDTO);
 assertEquals(HttpStatus.OK, response.getStatusCode());
 assertEquals("Records are updated", response.getBody());
}
}

