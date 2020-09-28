package com.example.todoapi.service;

import java.util.List;

import com.example.todoapi.model.Todo;

public interface TodoService {
	public List<Todo> getAllTodos();
	public Todo saveTodo(Todo todo);
	public Todo deleteTodoById(int id);
	public Todo findTodoById(int id);

}
