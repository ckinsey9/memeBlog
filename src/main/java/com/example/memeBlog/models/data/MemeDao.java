package com.example.memeBlog.models.data;

import com.example.memeBlog.models.Meme;
import org.springframework.data.repository.CrudRepository;

public interface MemeDao extends CrudRepository<Meme, Integer> {
}
