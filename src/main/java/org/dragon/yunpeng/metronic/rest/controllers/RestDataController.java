package org.dragon.yunpeng.metronic.rest.controllers;

import org.dragon.yunpeng.metronic.entities.Category;
import org.dragon.yunpeng.metronic.entities.SubCategory;
import org.dragon.yunpeng.metronic.pojos.FormDTO;
import org.dragon.yunpeng.metronic.pojos.ModalSearchResult;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	@GetMapping("/modalSearch")
	public List<String> search(@RequestParam("query") String query) {

		List<String> data = Arrays.asList("Apple", "Banana", "Orange", "Mango", "Grapes");
		// Filter data based on the search query
		return data.stream().filter(item -> item.toLowerCase().contains(query.toLowerCase()))
				.collect(Collectors.toList());
	}
	
	@GetMapping("/modalSearchDataTransfer")
    public List<ModalSearchResult> modalSearchDataTransfer(@RequestParam String query) {
        // Implement search logic here, e.g., querying the database
        
        // Example: Return static search results
        List<ModalSearchResult> results = new ArrayList<>();
        results.add(new ModalSearchResult("Data1", "Data2", "Data3"));
        results.add(new ModalSearchResult("Value1", "Value2", "Value3"));
        results.add(new ModalSearchResult("Item1", "Item2", "Item3"));
        
        return results;
    }
}
