package com.Project.toDoList.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Project.toDoList.Model.Todolist;

public interface Todorepo extends JpaRepository<Todolist, Long> {
	List<Todolist> findByCategory(String category);

	List<Todolist> findByStatus(String status);
}
