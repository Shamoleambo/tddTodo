package com.tidz.tddTodo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tidz.tddTodo.entity.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}
