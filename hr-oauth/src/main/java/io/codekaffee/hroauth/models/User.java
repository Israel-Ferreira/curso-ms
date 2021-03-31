package io.codekaffee.hroauth.models;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {

    private String email;
    private String name;
    private String password;

    private Set<Role> roles = new HashSet<>();

    public User(String email, String name, String password) {
        this.email = email;
        this.name = name;
        this.password = password;
    }

}
