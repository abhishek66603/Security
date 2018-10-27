package com.example.demo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class User {

	@Id
	@Email
	@NotEmpty
	@Column(unique = true)
	private String email;
	@NotEmpty
	private String name;
	@Size(min = 4)
	private String password;

	// one user will have -> lots of task to perform
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)		//One User - Many Task
	private List<Task> tasks;
	
	// User can be assigned -> multiple roles & single role can assigned to ->
	// multiple users
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLES", 
					joinColumns = {@JoinColumn(name = "USER_EMAIL", referencedColumnName = "email") }, 
			 inverseJoinColumns = {@JoinColumn(name = "ROLE_NAME", referencedColumnName = "name") })
	private List<Role> roles;

	public User() {

	}

	public User(String email, String name, String password) {
		this.email = email;
		this.name = name;
		this.password = password;
	}

	public User(String email, String name, String password, List<Task> tasks, List<Role> roles) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
		this.tasks = tasks;
		this.roles = roles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTask() {
		return tasks;
	}

	public void setTask(List<Task> tasks) {
		this.tasks = tasks;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [email=" + email + ", name=" + name + ", password=" + password + ", tasks=" + tasks + ", roles="
				+ roles + "]";
	}

}
