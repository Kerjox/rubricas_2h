package com.kerjox.bloque5_rubrica_2.Services;

import com.kerjox.bloque5_rubrica_2.Models.TodoModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TodoService {

	private static List<TodoModel> todos = new ArrayList<>();
	private static int todoCount = 3;

	static {
		todos.add(new TodoModel(1, "alcachofa", "Learn Spring MVC", new Date(), false));
		todos.add(new TodoModel(2, "alcachofa", "Learn Struts", new Date(), false));
		todos.add(new TodoModel(3, "alcachofa", "Learn Hibernate", new Date(), false));
	}

	public List<TodoModel> retrieveTodos(String user) {
		List<TodoModel> filteredTodos = new ArrayLis@Service
public class TodoService {

	private static List<TodoModel> todos = new ArrayList<>();
	private static int todoCount = 3;

	static {
		todos.add(new TodoModel(1, "alcachofa", "Learn Spring MVC", new Date(), false));
		todos.add(new TodoModel(2, "alcachofa", "Learn Struts", new Date(), false));
		todos.add(new TodoModel(3, "alcachofa", "Learn Hibernate", new Date(), false));
	}

	public List<TodoModel> retrieveTodos(String user) {
		List<TodoModel> filteredTodos = new ArrayList<>();
		for (TodoModel todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}t<>();
		for (TodoModel todo : todos) {
			if (todo.getUser().equals(user)) {
				filteredTodos.add(todo);
			}
		}
		return filteredTodos;
	}
}
