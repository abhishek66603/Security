package com.example.demo.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.User;

public interface UserDao extends CrudRepository<User, String>{

	List<User> findByNameLike(String name);

}
