package com.SOA.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Usuarios_SesionesDTO {

    private Integer IDSesiones;

    private UsuariosDTO usuario;
	
    private LocalDate fecha_ingreso;
	
	
}
