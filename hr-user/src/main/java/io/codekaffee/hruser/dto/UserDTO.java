package io.codekaffee.hruser.dto;

import java.util.HashSet;
import java.util.Set;

import io.codekaffee.hruser.models.Role;
import io.codekaffee.hruser.models.User;

public class UserDTO {
    private String email;
    private String userPassword;
    private Set<Role> roles = new HashSet<>();


    public UserDTO(){  
    }


    public UserDTO(User user){
        this.email = user.getEmail();
        this.userPassword = user.getPassword();
        this.roles = user.getRoles();
    }


    public UserDTO(String email, String userPassword, Set<Role> roles) {
        this.email = email;
        this.userPassword = userPassword;
        this.roles = roles;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getUserPassword() {
        return userPassword;
    }


    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    public Set<Role> getRoles() {
        return roles;
    }


    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }



}
