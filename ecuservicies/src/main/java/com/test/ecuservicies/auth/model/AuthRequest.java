package com.test.ecuservicies.auth.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class AuthRequest {

    private String username;
    private String password;
    
}
