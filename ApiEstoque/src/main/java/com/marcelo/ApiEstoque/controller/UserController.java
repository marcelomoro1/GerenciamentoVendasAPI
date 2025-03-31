package com.marcelo.ApiEstoque.controller;

import com.marcelo.ApiEstoque.model.Customer;
import com.marcelo.ApiEstoque.model.User;
import com.marcelo.ApiEstoque.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    //getAll
    @GetMapping
    public ResponseEntity<List<User>> getAll(){
        return ResponseEntity.ok(userService.getAll());
    }

    //getById
    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id){
        return ResponseEntity.ok(userService.getById(id));
    }

    //Create
    @PostMapping
    public ResponseEntity<User> saveuser(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.saveUser(user));
    }

    //Update
    @PutMapping("/{id}")
    public ResponseEntity<User> atualizar(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok(userService.updateUser(id, user));
    }

    //Delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }



}
