package com.Project.toDoList.Service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Project.toDoList.Model.Todolist;
import com.Project.toDoList.Repository.Todorepo;

@Service
public class ToDoService {
	
	
	private Todorepo todorepo;
	
	@Autowired
	public ToDoService(Todorepo todorepo) {
		this.todorepo=todorepo;
	}
	
	public List<Todolist> gettasks(){
		return todorepo.findAll();
	}
	
	public Todolist findById(long id) {
		Optional<Todolist> todo=todorepo.findById(id);
		if(todo.isEmpty()) {
			 throw new RuntimeException("Task not found with ID: " + id);
		}
		return todo.get();
	}
	
	public List<Todolist> findByCategory(String category){
		List<Todolist> todo=todorepo.findByCategory(category);
		return todo;
	}
	public List<Todolist> findByStatus(String status){
		List<Todolist> todo=todorepo.findByStatus(status);
		return todo;
	}
	public Todolist save(Todolist todolist) {
		if(todolist.getStatus()==null||todolist.getStatus().trim().isEmpty()) {
			todolist.setStatus("no");
		}
		 else {
	            // This ensures new tasks also get a lowercase status
				todolist.setStatus(todolist.getStatus().toLowerCase());
			}
		return todorepo.save(todolist);
	}
	
	
	public void DeleteById(long id) {
		findById(id);
		todorepo.deleteById(id);
	}
	
	public Todolist updateStatus(long id, String newStatus) {
		Todolist taskToUpdate = findById(id);
		taskToUpdate.setStatus(newStatus.toLowerCase());
		
		
		// Save the updated object back to the database.
		return todorepo.save(taskToUpdate);
	}
}
