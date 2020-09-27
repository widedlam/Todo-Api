package com.example.TodoAPI.model;

import java.io.Serializable;

public class Todo implements Serializable {
	
	private int id;
	private String description;

	public Todo() {
		super();

	}
	
	public Todo(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

}
