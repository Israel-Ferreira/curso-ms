package io.codekaffee.hrpayroll.models;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class StandardError {
    private String message;
    private Integer status;
    private LocalDateTime moment;
    
    public StandardError(String message, Integer status){
        this.message = message;
        this.status = status;
        this.moment = LocalDateTime.now();
    }
}
