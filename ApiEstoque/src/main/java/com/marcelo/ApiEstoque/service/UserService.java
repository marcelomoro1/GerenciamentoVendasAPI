package com.marcelo.ApiEstoque.service;

import com.marcelo.ApiEstoque.exception.EmailAlreadyExistsException;
import com.marcelo.ApiEstoque.exception.UserNotFoundException;
import com.marcelo.ApiEstoque.model.User;
import com.marcelo.ApiEstoque.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; // Para criptografar senhas

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User saveUser(User user){
        if(userRepository.existsByEmail(user.getEmail())){
            throw new IllegalArgumentException("Usuario com esse e-mail já existe.");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword())); //criptografando antes de salvar
        return userRepository.save(user);
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Usuário não encontrado"
                ));

    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("Usuário não encontrado."));
    }

    public User updateUser(Long id, User userUpdated) {
        User existingUser = getById(id);

        // Valida se o novo e-mail já pertence a outro usuário
        if (!existingUser.getEmail().equals(userUpdated.getEmail())){
            if (userRepository.existsByEmailAndIdNot(userUpdated.getEmail(), id)) {
                throw new EmailAlreadyExistsException("E-mail já está em uso.");
            }
            existingUser.setEmail(userUpdated.getEmail());
        }

        // Atualiza outros campos
        existingUser.setName(userUpdated.getName());
        existingUser.setEmail(userUpdated.getEmail());


        // Atualiza senha apenas se for fornecida
        if (userUpdated.getPassword() != null && !userUpdated.getPassword().isEmpty()) {
            existingUser.setPassword(passwordEncoder.encode(userUpdated.getPassword()));
        }

        return userRepository.save(existingUser);
    }

    public void deleteUser(Long id){
        if(!userRepository.existsById(id)){
            throw new UserNotFoundException("Usuário não encontrado.");
        }
        userRepository.deleteById(id);
    }

}
