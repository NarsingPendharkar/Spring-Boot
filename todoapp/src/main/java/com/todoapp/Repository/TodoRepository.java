package com.todoapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.Entity.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
