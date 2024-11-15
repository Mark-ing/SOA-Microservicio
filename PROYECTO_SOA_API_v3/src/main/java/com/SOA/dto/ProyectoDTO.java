package com.SOA.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;


@Data
public class ProyectoDTO {

    private Integer IDProyecto;

    private EquipoDTO equipo;
    
    @NotNull(message="{null.nombre}")
	@NotBlank(message="{blank.nombre}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.nombre}")
    private String nombre_proyecto;

    @NotNull(message="{null.descripcion}")
	@NotBlank(message="{blank.descripcion}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.descripcion}")
    private String descripcion;

    private LocalDate fecha_inicio;

    private LocalDate fecha_fin;

    @NotNull(message="{null.estado}")
	@NotBlank(message="{blank.estado}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.estado}")
    private String estado;

    private Jefe_ProyectoDTO jefe_proyecto;

	
}
