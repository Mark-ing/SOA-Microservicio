package com.SOA.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UsuariosDTO {

    private Integer IDUsuario;

    private Rol_UsuariosDTO rol_usuarios; // Relación con Rol

    private AreaDTO area; // Relación con Area

    private String correo;

    private String contrasena;
    
    private LocalDate fechaCreacion;

    private String estado;

}
