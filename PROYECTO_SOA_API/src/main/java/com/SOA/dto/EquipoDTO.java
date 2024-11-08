package com.SOA.dto;


import java.time.LocalDate;

import lombok.Data;

@Data
public class EquipoDTO {
	
    private Integer idEquipo;

    private String nombre_equipo;
    
    private LocalDate fechaCreacion;

    private String estadoEquipo;

}
