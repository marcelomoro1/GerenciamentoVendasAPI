package com.marcelo.ApiEstoque.controller;

import com.marcelo.ApiEstoque.model.Customer;
import com.marcelo.ApiEstoque.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    //getAll
    @GetMapping()
    public ResponseEntity<List<Customer>> getAll(){
        return ResponseEntity.ok(customerService.getAll());
    }
    //getByID
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }
    //Inserir
    @PostMapping
    public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
        return ResponseEntity.status(HttpStatus.CREATED).body(customerService.saveCustomer(customer));
    }
    //Atualizar
    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer, @PathVariable Long id){
        return ResponseEntity.ok(customerService.updateCustomer(customer,id));
    }
    //Deletar
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id){
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }

}
