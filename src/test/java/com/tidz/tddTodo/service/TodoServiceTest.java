package com.tidz.tddTodo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

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

}
