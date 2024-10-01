package org.dragon.yunpeng.metronic.controllers;

import org.dragon.yunpeng.metronic.pojos.FormObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ListInFormController {
	
	@GetMapping("/listInForm")
	public String showListInFormPage() {
		return "pages/listInFormPage";
	}
	
	@PostMapping("/submitListInForm")
	public String handleFormSubmission(@ModelAttribute FormObject formObject, Model model) {
		// Access the 'name' field
		System.out.println("Name: " + formObject.getName());

		// Access the 'inputs' list
		for (String input : formObject.getInputs()) {
			System.out.println("Input: " + input);
		}

		// Add the object to the model
		model.addAttribute("submittedData", formObject);
		return "pages/listInFormResultPage";
	}
}
