package com.tidz.tddTodo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.tidz.tddTodo.entity.Todo;

@DataJpaTest
public class TodoRepositoryTest {

	@Autowired
	private TodoRepository todoRepository;

	@Test
	void testSaveAndFindTodo() {
		Todo todo = new Todo();
		todo.setTitle("title");
		todo.setCompleted(false);

		this.todoRepository.save(todo);

		List<Todo> todos = this.todoRepository.findAll();

		assertEquals(1, todos.size());
		assertEquals("title", todos.get(0).getTitle());
	}
}
