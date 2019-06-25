package com.example.memeBlog.models.data;

import com.example.memeBlog.models.Meme;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface MemeDao extends CrudRepository<Meme, Integer> {
}
