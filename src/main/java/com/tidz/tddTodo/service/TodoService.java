package com.tidz.tddTodo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.repository.TodoRepository;

@Service
public class TodoService {

	@Autowired
	private TodoRepository todoRepository;

	public List<Todo> getAllTodos() {
		return this.todoRepository.findAll();
	}

	public Todo addTodo(Todo todo) {
		return this.todoRepository.save(todo);
	}

	public void completeTodo(Long id) {
		Todo todo = this.todoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Todo not found"));
		todo.setCompleted(true);
		this.todoRepository.save(todo);
	}
}
