package io.codekaffee.hruser.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.codekaffee.hruser.dto.UserDTO;
import io.codekaffee.hruser.exceptions.UserNotFoundException;
import io.codekaffee.hruser.models.User;
import io.codekaffee.hruser.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<User> getById(@PathVariable Long id) {
        User user = userRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(user);
    }

    @GetMapping("/search")
    public ResponseEntity<UserDTO> searchByEmail(@RequestParam String email){
        User user = this.userRepository.findByEmail(email)
            .orElseThrow(UserNotFoundException::new);


        UserDTO userDTO = new UserDTO(user);



        return ResponseEntity.ok(userDTO);
    }

}
