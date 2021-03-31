package io.codekaffee.hroauth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.codekaffee.hroauth.models.User;
import io.codekaffee.hroauth.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<User> searchUserByEmail(@RequestParam String email){
        User user = userService.findUserByEmail(email);

        return ResponseEntity.ok(user);
    }
}
