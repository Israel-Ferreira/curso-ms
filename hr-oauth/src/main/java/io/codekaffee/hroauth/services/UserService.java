package io.codekaffee.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import io.codekaffee.hroauth.clients.UserFeignClient;
import io.codekaffee.hroauth.exceptions.EmailNotFoundException;
import io.codekaffee.hroauth.models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService {
    
    @Autowired
    private UserFeignClient userFeignClient;


    public User findUserByEmail(String email){
        ResponseEntity<User> userResp = userFeignClient.searchByEmail(email);

        log.info("Status Code: " + userResp.getStatusCode().value());

        if(userResp.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            log.error("Email not found: " + email);
            throw new EmailNotFoundException();
        }


        log.info("Email Found: " + userResp.getBody().getEmail());
        return userResp.getBody();
    }
}
