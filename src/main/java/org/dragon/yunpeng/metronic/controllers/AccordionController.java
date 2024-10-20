package org.dragon.yunpeng.metronic.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AccordionController {

	public static class Item {
		private String title;
		private String content;

		public Item(String title, String content) {
			this.title = title;
			this.content = content;
		}

		public String getTitle() {
			return title;
		}

		public String getContent() {
			return content;
		}
	}

	@GetMapping("/forms/accordionsPage")
	public String getAccordionPage(Model model) {
		List<Item> items = new ArrayList<>();
		items.add(new Item("Accordion 1", "Content for accordion 1."));
		items.add(new Item("Accordion 2", "Content for accordion 2."));
		items.add(new Item("Accordion 3", "Content for accordion 3."));

		// Add the list of items to the model
		model.addAttribute("items", items);

		return "pages/accordionPage"; // This refers to the Thymeleaf template name
	}
}
