package com.todoapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import com.todoapp.Entity.Todo;
import com.todoapp.Entity.User;
import com.todoapp.Repository.TodoRepository;
import com.todoapp.Repository.UserRepository;
import com.todoapp.Service.TodoService;
import com.todoapp.ServiceImpl.TodoServiceImpl;

@Controller
public class Todocontroller {

	@Autowired
	private TodoServiceImpl todoServiceImpl;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TodoService todoService;
	@Autowired
	private TodoRepository todoRepository;
	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/home")
	public String getMethodName() {
		return "Landing";
	}

	@GetMapping("/gettodos/{id}")
	public ResponseEntity<Todo> getMethodName(@PathVariable("id") int id) {
		String url = "https://dummyjson.com/todos/" + id;
		Todo todo = restTemplate.getForObject(url, Todo.class);
		String userUrl = "https://dummyjson.com/users/" + todo.getId();
	    User user = restTemplate.getForObject(userUrl, User.class);
	    todo.setUser(user);
	    user.setId(todo.getId());
	    userRepository.save(user);
	    todoRepository.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}

}
