package com.todoapp.Entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	
	private Long id;
	@NotBlank
    private String firstName;
	@NotBlank
    private String lastName;
	@NotNull
    private int age;
	@NotBlank
    private String gender;
	@Email
	@Column(name="email",unique = true,nullable = false)
    private String email;
	@NotNull
    private String phone;
	@Column(name = "username",unique = true,nullable = false)
    private String username;
	@NotBlank
    private String password;
	
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos = new ArrayList<>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Todo> getTodos() {
		return todos;
	}
	public void setTodos(List<Todo> todos) {
		this.todos = todos;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, @NotBlank String firstName, @NotBlank String lastName, @NotNull int age,
			@NotBlank String gender, @Email String email, @NotNull String phone, String username,
			@NotBlank String password, List<Todo> todos) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.todos = todos;
	}
	
	public void addTodo(Todo todo) {
        todos.add(todo);
        todo.setUser(this);  // Ensuring bidirectional mapping
    }

	

}
