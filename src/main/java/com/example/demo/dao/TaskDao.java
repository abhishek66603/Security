package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Task;
import com.example.demo.entity.User;

public interface TaskDao extends CrudRepository<Task, Long> {

	List<Task> findByUser(User user);

}
