package com.example.TodoAPI.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.TodoAPI.model.Todo;
import com.example.TodoAPI.service.TodoServiceImpl;


@RestController
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequestMapping("/todos")
public class TodoResource {

	@Autowired
	TodoServiceImpl todoService;

	@GetMapping()
	public ResponseEntity<List<Todo>> getAllTodos() {
		try {
			return new ResponseEntity<List<Todo>>(todoService.getAllTodos(), HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<List<Todo>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping()
	public ResponseEntity<Todo> addTodo(@RequestBody Todo todoRequest) {
		try {
			Todo todo = todoService.saveTodo(todoRequest);
			return new ResponseEntity<Todo>(todo, HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping()
	public ResponseEntity<Todo> updateTodo(@RequestBody Todo todoRequest) {
		Todo todo = todoService.saveTodo(todoRequest);
		try {
			if (todo != null) {
				return new ResponseEntity<Todo>(todo, HttpStatus.OK);
			}
			return new ResponseEntity<Todo>(HttpStatus.BAD_REQUEST);
		} catch (Exception ex) {
			return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/{id}")
	public ResponseEntity<Todo> getTodo(@PathVariable int id, UriComponentsBuilder uriComponentBuilder)
			 {
		Todo todo = todoService.findTodoById(id);
		try {
			if (todo != null) {
				return new ResponseEntity<Todo>(todo, HttpStatus.OK);
			}
			return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Todo> deleteTodoById(@PathVariable int id) {
		Todo todo = todoService.deleteTodoById(id);
		try {
			if (todo == null) {
				return new ResponseEntity<Todo>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<Todo>(HttpStatus.OK);
		} catch (Exception ex) {
			return new ResponseEntity<Todo>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
