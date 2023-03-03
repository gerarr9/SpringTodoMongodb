package com.example.task1.controller;

import com.example.task1.model.TodoDTO;
import com.example.task1.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController

public class TodoController {
    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/todos")
    public ResponseEntity<?> getAllTodos() {
        List<TodoDTO> todo = todoRepository.findAll();
        if (todo.size() > 0) {
            return new ResponseEntity<List<TodoDTO>>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Нет задач", HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todos")
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO todo) {
        try {
            todo.setCreatedAt(new Date(System.currentTimeMillis()));
            todoRepository.save(todo);
            return new ResponseEntity<TodoDTO>(todo, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("todos/{id}")
    public ResponseEntity<?> getSingleTodo(@PathVariable("id") String id) {
        Optional<TodoDTO> todoDTOOptional = todoRepository.findById(id);
        if (todoDTOOptional.isPresent()) {
            return new ResponseEntity<>(todoDTOOptional.get(), HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("Не найденно задачи по данному id: "+id,HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("todos/{id}")
    public ResponseEntity<?> updateById(@PathVariable("id") String id,@RequestBody TodoDTO todo) {
        Optional<TodoDTO> todoDTOOptional = todoRepository.findById(id);
        if (todoDTOOptional.isPresent()) {
            TodoDTO todoToSave =todoDTOOptional.get();
            todoToSave.setCompleted(todo.getCompleted() !=null ? todo.getCompleted() : todoToSave.getCompleted());
            todoToSave.setTodo(todo.getTodo() !=null ? todo.getTodo() : todoToSave.getTodo());
            todoToSave.setDescription(todo.getDescription() !=null ? todo.getDescription() : todoToSave.getDescription());
            todoToSave.setUpdatedAt(new Date(System.currentTimeMillis()));
            todoRepository.save(todoToSave);
            return  new ResponseEntity<>(todoToSave,HttpStatus.OK);
        }else {
            return  new ResponseEntity<>("Не найденно задачи по данному id: "+id,HttpStatus.NOT_FOUND);
        }
    }
}
