package com.test.ecuservicies.system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MineducPasswordRequest {
 
    private String usuario;
    private String oldapassword;
    private String password;
    private String confirmPassword;
}