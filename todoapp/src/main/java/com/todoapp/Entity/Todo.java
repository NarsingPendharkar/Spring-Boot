package com.todoapp.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
public class Todo {
	
	@Id
   
    private Long id;
    private String todo;
    private boolean completed;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTodo() {
		return todo;
	}
	public void setTodo(String todo) {
		this.todo = todo;
	}
	public boolean isCompleted() {
		return completed;
	}
	public void setCompleted(boolean completed) {
		this.completed = completed;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Todo(Long id, String todo, boolean completed, User user) {
		super();
		this.id = id;
		this.todo = todo;
		this.completed = completed;
		this.user = user;
	}
	public Todo() {
		super();
		// TODO Auto-generated constructor stub
	}

}
