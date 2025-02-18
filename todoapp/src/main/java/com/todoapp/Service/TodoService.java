package com.todoapp.Service;

import java.util.List;
import java.util.Optional;

import com.todoapp.Entity.Todo;

public interface TodoService {
	
	public Optional<Todo> getTodos(int id);

}
