package com.test.ecuservicies.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MineducRecoveryRequest {
    @NotNull
    private String usuario;
}
