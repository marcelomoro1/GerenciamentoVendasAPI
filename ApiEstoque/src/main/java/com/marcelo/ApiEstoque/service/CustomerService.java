package com.marcelo.ApiEstoque.service;

import com.marcelo.ApiEstoque.model.Customer;
import com.marcelo.ApiEstoque.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer saveCustomer(Customer customer){
        if(customerRepository.existsByEmail(customer.getEmail())){
            throw new IllegalArgumentException("Cliente com esse e-mail já existe.");
        }

        return customerRepository.save(customer);
    }
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id){
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Cliente não encontrado."));
    }

    public Customer updateCustomer(Customer customerUpdated, Long id) {
        Customer existingCustomer = customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

        // Verifica se o e-mail foi alterado
        if (!existingCustomer.getEmail().equals(customerUpdated.getEmail())) {
            // Se foi alterado, valida se o novo e-mail já existe (de outro cliente)
            if (customerRepository.existsByEmailAndIdNot(customerUpdated.getEmail(), id)) {
                throw new IllegalArgumentException("E-mail já está em uso por outro cliente.");
            }
        }

        // Atualiza apenas os campos permitidos
        existingCustomer.setName(customerUpdated.getName());
        existingCustomer.setPhone(customerUpdated.getPhone());

        // Só atualiza o e-mail se for diferente e não existir no banco
        if (!existingCustomer.getEmail().equals(customerUpdated.getEmail())) {
            existingCustomer.setEmail(customerUpdated.getEmail());
        }

        return customerRepository.save(existingCustomer);
    }
    public void deleteCustomer(Long id){
        if(!customerRepository.existsById(id)){
            throw new RuntimeException("Cliente não encontrado");
        }

        customerRepository.deleteById(id);
    }

}
