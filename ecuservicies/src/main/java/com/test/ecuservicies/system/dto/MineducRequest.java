package com.test.ecuservicies.system.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MineducRequest {
    @NotNull
    @Size(max = 10)
    private String usuario;
    @NotNull
    private String password;

}
