package org.dragon.yunpeng.metronic.controllers;

import org.dragon.yunpeng.metronic.pojos.Parent;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AccordionFormController {
	@GetMapping("/accordionForm")
	public String showAccordionForm(Model model) {
		// Initialize parent object with children
		Parent parent = new Parent();
		model.addAttribute("parent", parent);
		return "pages/accordionForm";
	}

	@GetMapping("/dynamicAccordionForm")
	public String showDynamicAccordionForm(Model model) {
		// Initialize parent object with children
		Parent parent = new Parent();
		model.addAttribute("parent", parent);
		return "pages/dynamicAccordionForm";
	}

	@PostMapping("/accordionForm/submit")
	public String submitForm(@ModelAttribute Parent parent, Model model) {
		// Here, you can save the parent object with its children
		// For demonstration, we will just return the object to a result page
		model.addAttribute("parent", parent);
		return "pages/accordionFormResultPage";
	}
}
