package com.todoapp.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todoapp.Entity.Todo;
import com.todoapp.Repository.TodoRepository;
import com.todoapp.Service.TodoService;

@Service
public class TodoServiceImpl  implements TodoService{
	
	@Autowired
	private TodoRepository todoRepository;
	
	
	public Optional<Todo> getTodos(int id){
		return todoRepository.findById(id);
	}

}
