package org.dragon.yunpeng.metronic.controllers;

import org.dragon.yunpeng.metronic.pojos.MainForm;
import org.dragon.yunpeng.metronic.pojos.SubForm;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class ModalDynamicFormController {

	@GetMapping("/forms/modalDynamicForm")
	public String loadModalDynamicForm(Model model) {
		// Load data from the server (could be from a database)
		MainForm mainForm = new MainForm();
		mainForm.setMainInput("Initial Value");

		List<SubForm> subFormList = Arrays.asList(new SubForm("Sample Field 1", "Sample Field 2"),
				new SubForm("Sample Field 3", "Sample Field 4"));
		mainForm.setSubFormList(subFormList);

		model.addAttribute("mainForm", mainForm);
		return "pages/modalDynamicFormPage"; // Thymeleaf template name
	}

	@PostMapping("/forms/submitModalDynamicForm")
	public String submitModalDynamicForm(@ModelAttribute MainForm mainForm, Model model) {
		// Handle the submitted form data
		model.addAttribute("submittedData", mainForm);
		return "pages/modalDynamicFormResultPage"; // Return to a result page after submission
	}
}
