package com.aweb.todo_list.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.aweb.todo_list.repository.TodoRepository;

@Controller 
public class TodoController {

    @Autowired 
    TodoRepository todoRepository;

    @GetMapping 
    public ModelAndView list(){
        var ModelAndView = new ModelAndView("list");
        ModelAndView.addObject("todos", todoRepository.findAll());
        return ModelAndView;
    }
