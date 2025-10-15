package com.test.ecuservicies.system.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewEmergencyRequest {

    @NotNull
    private String id_fuente;
    @NotNull
    private String nombre;
    @NotNull
    private String apellido;
    @NotNull
    private String telefono;
    @NotNull
    private Double  latitud;
    @NotNull
    private Double  longitud;
    private LocalDateTime timestamp;
    private String direccion_evento;
    @NotNull
    @Size(max = 6)
    private String id_incidente;
    private String descripcion;
    @NotNull
    @Size(max = 3)
    private String visto;
    @NotNull
    @Size(max = 10)
    private String cedula;
    @NotNull
    private String ecuatoriano;
    private String discapacidad;
    @NotNull
    @Size(max = 2)
    private String sangre;
    private String alergias;
    private String emergencia_transportista;
    private String emergencia_nombre;
    private String emergencia_apellido;
    private String emergencia_codigo;
    private String emergencia_telefono;
    private String emergencia_relacion;
    private String emergencia_cooperativa;
    private String emergencia_placa;
    private String tipo_discapacidad;
    private String grado_discapacidad;
    private String telefono_contacto_discapacidad_codigo;
    private String telefono_contacto_discapacidad;
    private String entidad_envia;
}
