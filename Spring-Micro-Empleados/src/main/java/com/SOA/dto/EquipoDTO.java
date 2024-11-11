package com.SOA.dto;


import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EquipoDTO {
	
    private Integer idEquipo;

    @NotNull(message="{null.nombre_equipo}")
	@NotBlank(message="{blank.nombre_equipo}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.nombre_equipo}")
    private String nombre_equipo;
    
    private LocalDate fechaCreacion;

    @NotNull(message="{null.estado}")
	@NotBlank(message="{blank.estado}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.estado}")
    private String estadoEquipo;

}
