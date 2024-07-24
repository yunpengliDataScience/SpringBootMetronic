package org.dragon.yunpeng.metronic.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ToDoController {
	Logger logger = LoggerFactory.getLogger(ToDoController.class);

	@GetMapping("/toDoSearch")
	public String listToDos(Model model) {

		return "pages/toDoSearch";
	}

	@GetMapping("/toDoDetail")
	public String toDoDetail(Model model) {

		return "pages/toDoDetail";
	}

	@GetMapping("/toDoList")
	public String toDoList(Model model) {

		return "pages/toDoList";
	}

}
