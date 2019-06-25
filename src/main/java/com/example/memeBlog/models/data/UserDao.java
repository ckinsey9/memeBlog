package com.example.memeBlog.models.data;

import com.example.memeBlog.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Integer>{
}

