package com.test.ecuservicies.system.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetStatusRequest {

    @NotNull
    private String id;
    @NotNull
    private Double latitud;
    @NotNull
    private Double longitud;
    
}
