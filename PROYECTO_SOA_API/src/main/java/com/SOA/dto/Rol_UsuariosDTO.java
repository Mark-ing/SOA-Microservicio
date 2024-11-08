package com.SOA.dto;

import java.time.LocalDate;

import lombok.Data;

@Data  
public class Rol_UsuariosDTO {

    private Integer idRol;

    private String descripcion;
    
    private LocalDate fechaCreacion;

}
