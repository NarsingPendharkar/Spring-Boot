package com.todoapp.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.todoapp.Entity.User;
import com.todoapp.Repository.UserRepository;


@Controller
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	@Autowired
	private RestTemplate restTemplate;
	
	
	@Autowired()
	private UserRepository userRepository;
	
	@PostMapping("/saveUser")
	public ResponseEntity<String>saveUser( @RequestBody User user, BindingResult result){
		if (result.hasErrors()) {
			return new ResponseEntity<String>("Error in user data ", HttpStatus.NOT_ACCEPTABLE);
		}
		try {
			System.out.println(user.toString());
			userRepository.save(user);
			return new ResponseEntity<String>("User saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Error in saving user !", HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> getUsers() {
        try {
            List<User> users = userRepository.findAll();
            logger.info("Fetched users: {}", users);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            logger.error("Error fetching users", e);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
	
	@GetMapping("/page")
	public String getMethodName() {
		return "index";
	}
	
	@GetMapping("/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable int id) {
        String url = "https://dummyjson.com/users/" + id;  
        User  response = restTemplate.getForObject(url, User.class);
			return new ResponseEntity<User>(response, HttpStatus.OK);   
    }
	

}
