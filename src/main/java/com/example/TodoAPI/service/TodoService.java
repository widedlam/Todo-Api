package com.example.TodoAPI.service;

import java.util.List;

import com.example.TodoAPI.model.Todo;

public interface TodoService {
	public List<Todo> getAllTodos();
	public Todo saveTodo(Todo todo);
	public Todo deleteTodoById(int id);
	public Todo findTodoById(int id);

}
