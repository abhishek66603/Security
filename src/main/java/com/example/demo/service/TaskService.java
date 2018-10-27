package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TaskDao;
import com.example.demo.entity.Task;
import com.example.demo.entity.User;

@Service
public class TaskService {
	
	@Autowired
	private TaskDao taskDao;
	
	public void addTask(Task task, User user) {
		task.setUser(user);
		taskDao.save(task);
	}
	
	public List<Task> findUserTask(User user){
		return taskDao.findByUser(user);
	}
	
}
