package com.SOA.dto;

import lombok.Data;

@Data
public class EmpleadoDTO {
	
    private Integer idEmpleado;

    private UsuariosDTO usuario;

    private String nombre;

    private String apellido;

    private Rol_EquipoDTO rol_equipo;

}