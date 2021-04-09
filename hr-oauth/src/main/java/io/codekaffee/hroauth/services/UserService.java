package io.codekaffee.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import io.codekaffee.hroauth.clients.UserFeignClient;
import io.codekaffee.hroauth.exceptions.EmailNotFoundException;
import io.codekaffee.hroauth.models.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserService implements UserDetailsService {
    
    @Autowired
    private UserFeignClient userFeignClient;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;


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


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<User> userResp = userFeignClient.searchByEmail(username);

        log.info("Status Code: " + userResp.getStatusCode().value());

        if(userResp.getStatusCode().equals(HttpStatus.NOT_FOUND)){
            log.error("Email not found: " + username);
            throw new UsernameNotFoundException("Email not found");
        }

        
        boolean pwdMatches = passwordEncoder.matches("teste123", userResp.getBody().getPassword());

        System.out.println(pwdMatches);
        System.out.println(userResp.getBody().getPassword());


        log.info("Email Found: " + userResp.getBody().getEmail());




        return userResp.getBody();
    }
}
