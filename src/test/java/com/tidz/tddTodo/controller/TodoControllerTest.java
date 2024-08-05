package com.tidz.tddTodo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.tidz.tddTodo.entity.Todo;
import com.tidz.tddTodo.service.TodoService;

@WebMvcTest(TodoController.class)
public class TodoControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private TodoService todoService;

	@Test
	void testGetTodos() throws Exception {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		when(this.todoService.getAllTodos()).thenReturn(List.of(todo));

		this.mockMvc.perform(get("/todos").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(content().json("[{'title': 'title', 'completed': false}]"));
	}
}
