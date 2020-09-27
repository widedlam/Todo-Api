package com.example.TodoAPI.service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.TodoAPI.model.Todo;

@Service
public class TodoServiceImpl {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static int idCounter = 0;

	static {
		todos.add(new Todo(++idCounter, "Activity I description"));
		todos.add(new Todo(++idCounter, "Activity II description"));
		todos.add(new Todo(++idCounter, "Activity III description"));
	}

	public List<Todo> getAllTodos() {
		return todos;
	}

	public Todo saveTodo(Todo todo) {
		if (todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
		} else {
			deleteTodoById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo deleteTodoById(int id) {
		Todo todo = findTodoById(id);
		if (todo == null) {
			return null;
		}
		todos.remove(todo);
		return todo;
	}

	public Todo findTodoById(int id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}
}
