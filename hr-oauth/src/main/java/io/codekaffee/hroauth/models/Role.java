package io.codekaffee.hroauth.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Role {
    private Long id;
    private String roleName;

    public Role(String roleName){
        this.roleName = roleName;
    }
}
