package com.kerjox.bloque5_rubrica_2.Controllers;

import com.kerjox.bloque5_rubrica_2.Services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodosController {

	@Autowired
	TodoService service;

	@RequestMapping(value="/list-todos", method = RequestMethod.GET)
	public String showTodos(ModelMap model){
		String name = (String) model.get("name");
		model.put("todos", service.retrieveTodos(name));
		return "list-todos";
	}
}

