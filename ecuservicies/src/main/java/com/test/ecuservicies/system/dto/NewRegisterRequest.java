package com.test.ecuservicies.system.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class NewRegisterRequest {

    @NotNull
    @Size(max = 10)
    private String cedula;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String telefono;
    @NotNull
    private boolean ecuatoriano;
    @NotNull
    @Size(max = 2)
    private String sangre;
    private String alergias;
    private String discapacidad;
    private String tipo_discapacidad;
    private String grado_discapacidad;
    private String telefono_contacto_discapacidad;
    private String emergencia_transportista;
    private String emergencia_nombre;
    private String emergencia_apellido;
    private String emergencia_telefono;
    private String emergencia_relacion;
    private String emergencia_cooperativa;
    private String emergencia_placa;
}
