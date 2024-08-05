package com.tidz.tddTodo.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

public class TodoTest {

	@Test
	public void testTodoEntity() {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		assertEquals(todo.getTitle(), "title");
		assertFalse(todo.isCompleted());
	}
}
