package com.SOA.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Usuarios_SesionesDTO {

    private Integer IDSesiones;

    private UsuariosDTO usuario;
	
    private LocalDate fecha_ingreso;
	
	
}
