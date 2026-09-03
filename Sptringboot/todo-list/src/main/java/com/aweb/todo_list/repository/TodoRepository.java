package com.aweb.todo_list.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aweb.todo_list.model.Todo;

@Repository 
public interface TodoRepository extends JpaRepository<Todo, Long> {

    

    
}
