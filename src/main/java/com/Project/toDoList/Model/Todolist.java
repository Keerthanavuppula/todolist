package com.Project.toDoList.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Todolist")
public class Todolist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="task_description")
	private String task_description;
	
	@Column(name="category")
	private String category;
	
	@Column(name="status")
	private String status;
	

	public Todolist() {
		super();
	}

	public Todolist(long id, String task_description, String category, String status) {
		super();
		this.id = id;
		this.task_description = task_description;
		this.category = category;
		this.status = status;
	}
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Todolist [id=" + id + ", task_description=" + task_description + ", category=" + category + ", completed="
				+ status + "]";
	}
	
	
}