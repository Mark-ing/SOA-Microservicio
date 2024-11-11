package com.SOA.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class EmpleadoDTO {
	
    private Integer idEmpleado;

	private int usuario;

    @NotNull(message="{null.nombre}")
	@NotBlank(message="{blank.nombre}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.nombre}")
    private String nombre;

    @NotNull(message="{null.apellido}")
	@NotBlank(message="{blank.apellido}")
	@Pattern(regexp="^[a-zA-ZáéíóúÁÉÍÓÚüÜñÑ\\s]{3,20}$",message = "{pattern.apellido}")
    private String apellido;

    private Rol_EquipoDTO rol_equipo;

}