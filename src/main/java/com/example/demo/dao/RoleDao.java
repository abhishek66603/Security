package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Role;

public interface RoleDao extends CrudRepository<Role, String> {

}
