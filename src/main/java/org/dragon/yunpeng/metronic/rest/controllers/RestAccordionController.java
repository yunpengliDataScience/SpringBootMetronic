package org.dragon.yunpeng.metronic.rest.controllers;

import org.dragon.yunpeng.metronic.pojos.Parent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/accordions")
public class RestAccordionController {

	// Define an inner class or a separate class representing each object
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

	// Simulate a service that provides a list of items
	@GetMapping("/items")
	public List<Item> getItems() {
		List<Item> items = new ArrayList<>();
		items.add(new Item("Accordion 1", "Content for accordion 1."));
		items.add(new Item("Accordion 2", "Content for accordion 2."));
		items.add(new Item("Accordion 3", "Content for accordion 3."));
		return items;
	}
	
	@GetMapping("/dynamicAccordionFormObject")
	public Parent getFormObject() {
		Parent parent = new Parent();
		
		return parent;
	}
}
