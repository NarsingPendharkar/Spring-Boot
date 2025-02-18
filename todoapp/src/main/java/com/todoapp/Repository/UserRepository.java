package com.todoapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todoapp.Entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
