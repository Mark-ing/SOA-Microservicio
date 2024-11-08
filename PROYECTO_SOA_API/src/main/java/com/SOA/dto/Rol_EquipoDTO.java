package com.SOA.dto;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Rol_EquipoDTO {

    private Integer idrolEquipo;
	
    private String descripcion;
	
    private LocalDate fechaCreacion;

}
