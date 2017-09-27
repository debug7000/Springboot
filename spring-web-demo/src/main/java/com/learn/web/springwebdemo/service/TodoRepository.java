package com.learn.web.springwebdemo.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.learn.web.springwebdemo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer> {
	
	List<Todo> findByUser(String user);

}
