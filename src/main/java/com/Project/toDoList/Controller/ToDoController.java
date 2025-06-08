package com.Project.toDoList.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Project.toDoList.Model.Todolist;
import com.Project.toDoList.Service.ToDoService;

@RestController
public class ToDoController {
	
	private ToDoService todoService;
	
	@Autowired
	public ToDoController(ToDoService todoService) {
		this.todoService=todoService;
	}
	
	@GetMapping("/tasks")
	public List<Todolist> findAll(){
		return todoService.gettasks();
	}
	
	@GetMapping("/tasks/{id}")
	public Todolist findById(@PathVariable long id) {
		Todolist todo=todoService.findById(id);
		return todo;
	}
	@GetMapping("/taskscategory/{category}")
	public List<Todolist> findByCategory(@PathVariable String category){
		List<Todolist> todo=todoService.findByCategory(category);
		return todo;
	}
	@GetMapping("/taskstatus/{status}")
	public List<Todolist> findByStatus(@PathVariable String status){
		List<Todolist> todo=todoService.findByStatus(status);
		return todo;
	}
	@PostMapping("/tasks")
	public Todolist save(@RequestBody Todolist todolist) {
		return todoService.save(todolist);
	}
	
	@DeleteMapping("/tasks/{id}")
	public void DeleteById(@PathVariable long id) {
		todoService.DeleteById(id);
	}
	@PutMapping("/tasks/{id}/status")
	public Todolist updateTaskStatus(@PathVariable long id, @RequestBody StatusUpdateRequest request) {
		return todoService.updateStatus(id, request.getStatus());
	}

	static class StatusUpdateRequest {
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
	
}
