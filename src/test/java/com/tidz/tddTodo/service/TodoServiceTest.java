package com.tidz.tddTodo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.repository.TodoRepository;

public class TodoServiceTest {

	@Mock
	private TodoRepository todoRepository;

	@InjectMocks
	private TodoService todoService;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	public void testGetAllTodos() {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		when(this.todoRepository.findAll()).thenReturn(List.of(todo));

		List<Todo> todos = this.todoService.getAllTodos();
		assertEquals(1, todos.size());
		assertEquals("title", todos.get(0).getTitle());
	}

	@Test
	void testAddTodo() {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		when(this.todoRepository.save(todo)).thenReturn(todo);

		Todo createdTodo = this.todoService.addTodo(todo);
		assertEquals(todo, createdTodo);
	}

	@Test
	void testCompleTodo() {
		Todo todo = new Todo();
		todo.setId(1L);
		todo.setTitle("title");
		todo.setCompleted(false);

		when(this.todoRepository.findById(1L)).thenReturn(Optional.of(todo));

		this.todoService.completeTodo(1L);
		assertTrue(todo.isCompleted());
	}

}
