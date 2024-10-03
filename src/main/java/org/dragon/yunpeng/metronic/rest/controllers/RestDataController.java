package org.dragon.yunpeng.metronic.rest.controllers;

import org.dragon.yunpeng.metronic.entities.Category;
import org.dragon.yunpeng.metronic.entities.SubCategory;
import org.dragon.yunpeng.metronic.pojos.FormDTO;
import org.dragon.yunpeng.metronic.repositories.CategoryRepository;
import org.dragon.yunpeng.metronic.repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

@RestController
@RequestMapping("/api")
public class RestDataController {

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private SubCategoryRepository subCategoryRepository;

	@GetMapping("/categories")
	public List<Category> getCategories() {
		return categoryRepository.findAll();
	}

	@GetMapping("/subcategories/{categoryId}")
	public List<SubCategory> getSubCategories(@PathVariable Long categoryId) {

		System.out.println("Hi=" + categoryId);
		return subCategoryRepository.findByCategoryId(categoryId);
	}

	@PostMapping("/submit-form")
	public Map<String, Object> submitForm(@Valid @ModelAttribute FormDTO formDTO, BindingResult bindingResult) {
		Map<String, Object> response = new HashMap<>();

		if (bindingResult.hasErrors()) {
			Map<String, String> errors = new HashMap<>();
			for (FieldError error : bindingResult.getFieldErrors()) {
				errors.put(error.getField(), error.getDefaultMessage());
			}

			// Return the errors and old values to the client
			response.put("success", false);
			response.put("errors", errors);
			response.put("oldValues", formDTO);
			return response;
		}

		// If no validation errors
		response.put("success", true);
		return response;
	}
}
